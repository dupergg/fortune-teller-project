#   Before running you need to type the command "pip install transformers"
#   Then you need to type the command "pip install torch torchvision torchaudios"
#
#   You need to have at least python 3.8 installed on your computer and make sure that you are installing the pip instructions
#   on the correct python version. If you are using Visual Studio Code you might also want to check that the interperter being 
#   used is the correct version too. You can check that by looking in the lower right corner... im using Python 3.8.0 64-bit
#   if it isnt the version you want just click on the number and you should have options to change between the versions
#   currently downloaded.
#
#   Why are we not using gpt3 or gpt4... thats a great question random person. The reason why we do not use those two models
#   is because we would need to use OpenAI's cloud services to utilize those models. To access the models we would then need
#   an API key. You can obtain one of those keys by applying, or filling out a few forms. They then need to approve, we could
#   problably get a free version because we would be using it for a school project but i didnt feel like going through all
#   that trouble.         gpt2 has 1.5 billion parameters, gpt3 and gpt4 has 175 billion parameters. They are smarter

from flask import Flask, request, jsonify
from transformers import GPT2LMHeadModel, GPT2Tokenizer
import torch

app = Flask(__name__)

tokenizer = GPT2Tokenizer.from_pretrained('gpt2')
model = GPT2LMHeadModel.from_pretrained('gpt2')

def generate_fortune(prompt_text, max_length=25):
    while True:
        encoded_prompt = tokenizer.encode(prompt_text, add_special_tokens=False, return_tensors="pt")
        attention_mask = torch.ones(encoded_prompt.shape, dtype=torch.long)        
        output_sequences = model.generate(
            input_ids=encoded_prompt,
            do_sample = True,
            max_length=max_length,
            temperature=0.8,
            top_p=0.9,
            num_return_sequences=1
        )

        generated_sequence = output_sequences[0].tolist()
        text = tokenizer.decode(generated_sequence, clean_up_tokenization_spaces=True)

        redo_chars = ['said', 'says']
        if any(redo_word in text for redo_word in redo_chars):
            continue

        end_chars = ['.', '!', '?', '"']
        for char in end_chars:
            end_index = text.find(char)
            if end_index != -1:
                text = text[:end_index + 1]
                return text.strip()
    
        if len(text) >= max_length:
            continue

        return text.strip()

@app.route('/fortune', methods=['POST'])
def fortune_api():
    content = request.json
    prompt = content.get('prompt')
    if not prompt:
        return jsonify({"error": "No prompt provided"}), 400
    fortune = generate_fortune("your " + prompt + " fortune is")
    return jsonify({"Madam Bridgite says": fortune})

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', port=5000)