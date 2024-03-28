package fortuneteller;


import jep.Interpreter;
import jep.SharedInterpreter;

public class JepTest {
    public static void main(String[] args) throws Exception {
        String gm = "Good Morning!";
        
        try (Interpreter interp = new SharedInterpreter()) {
            interp.exec("from chatterbot import ChatBot");
            interp.exec("chatbot = ChatBot(\"Ron Obvious\")");

            interp.exec("from chatterbot.trainers import ListTrainer");

            interp.exec("conversation = [\"Hello\",\"Hi there!\",\"How are you doing?\",\"I'm doing great.\",\"That is good to hear\",\"Thank you.\",\"You're welcome.\"]");

            
            interp.exec("trainer = ListTrainer(chatbot)");

            interp.exec("trainer.train(conversation)");

            interp.exec("response = chatbot.get_response(" + "\"" + gm + "\"" + ")"); // this amalgamation is how we can use Strings and put it into the chatterbot
            interp.exec("print(response)");
        } 
    }
}