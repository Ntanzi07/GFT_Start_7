package EX1;

import EX1.Servicos.Email;
import EX1.Servicos.RedeSocial;
import EX1.Servicos.SMS;
import EX1.Servicos.WhatsApp;

public class App {

    public static void main(String[] args) {
        Email email = new Email();
        RedeSocial redeSocial = new RedeSocial();
        SMS sms = new SMS();
        WhatsApp whatsApp = new WhatsApp();

        email.receberMsg();
        redeSocial.receberMsg();
        sms.receberMsg();
        whatsApp.receberMsg();
    }
}
