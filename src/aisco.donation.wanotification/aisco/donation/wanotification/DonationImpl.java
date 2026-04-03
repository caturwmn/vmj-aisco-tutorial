package aisco.donation.wanotification;
import aisco.donation.core.DonationComponent;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;

public class DonationImpl extends DonationComponent {
    List <Object> donationList;
    private static final String API_TOKEN = "";
    private static final String WHATSAPP_NUMBER = "";

    public DonationImpl()
    {
        System.out.println("Donation via AISCO");
        donationList = new ArrayList<>();
    }

    public DonationImpl (String name, String email, String phone, int amount, String paymentMethod)
    {
        super(name, email, phone, amount,paymentMethod);
    }

    public void getDonation(){
        System.out.println(Arrays.asList(donationList));
        System.out.println("Sending WhatsappNotification");
        String message = "Received Donations: \n" + Arrays.asList(donationList).toString(); 
        sendWhatsappNotification(message);
    }

    public void addDonation(){
        donationList.add(new DonationImpl("Anisa", "anisa@jmail.com", "+62878 6654 3321", 2500000, "Transfer"));
        donationList.add(new DonationImpl("Dave", "dave@jmail.com", "+62828 2345 3091", 500000, "Cash"));
        donationList.add(new DonationImpl("Edo", "edo@jmail.com", "+62828 2345 3091", 300000, "Payku"));
    }

    public String toString() {
        return "- Donasi " + name + ": " + amount + " Payment Method: " + paymentMethod + "\n";
    }

    public void sendWhatsappNotification(String message) {
        try {
            String urlStr = "https://api.callmebot.com/whatsapp.php?phone="
                    + WHATSAPP_NUMBER
                    + "&text="
                    + message
                    + "&apikey="
                    + API_TOKEN;

            // URI uri = URI.create(urlStr);
            // URL url = uri.toURL();
            // HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // conn.setRequestMethod("GET");

            // int responseCode = conn.getResponseCode();
            System.out.println("WhatsApp API response: " + "(Simulated)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}