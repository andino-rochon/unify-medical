package giacom;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        User demoUser = new User("demouser", "123", "Demo Man", "01/01/2000",
                "111-111-1111");
        Scanner keyboard = new Scanner(System.in);
        String providerName;
        String address;
        System.out.print("USERNAME: ");
        if(!keyboard.nextLine().equals(demoUser.getUsername())){
            System.out.println("Such user does not exist");
            System.exit(1);
        }
        System.out.print("PASSWORD: ");
        if(!keyboard.next().equals(demoUser.getPassword())){
            System.out.println("Incorrect Password");
            System.exit(1);
        }
        keyboard.nextLine();
        System.out.println("Welcome! This is the tool to request medical records for your healthcare provider.");
        System.out.println("Who do you want to request your medical records from?");
        providerName = keyboard.nextLine();
        System.out.println("Enter facility address (Street Address - City, State Zip ");
        address = keyboard.nextLine();

        System.out.println("Do you agree to the following terms: \nAll medical records, meaning every page in my record, " +
                "including but not limited to: office notes, face sheets, history and physical, consultation notes, inpatient, " +
                "outpatient and emergency room treatment, all clinical charts, r ports, order sheets, progress notes, nurse's notes, " +
                "social worker records, clinic records, treatment plans, admission records, discharge summaries, requests for and reports of " +
                "consultations, documents, correspondence, test results, statements, questionnaires/histories, correspondence, photographs, videotapes, " +
                "telephone messages, and records received by other medical providers.\n\n All physical, occupational and rehab requests, " +
                "consultations and progress notes.\n\nAll disability, Medicaid or Medicare records including claim forms and record of denial " +
                "of benefits.\n\n\nAll employment, personnel or wage records.\n\nAll autopsy, laboratory, histology, cytology, pathology, " +
                "immunohistochemistry records and specimens; radiology records and films including CT scan, MRI, MRA, EMG, bone scan, myleogram; " +
                "nerve conduction study, echocardiogram and cardiac catheterization results, videos/CDs/films/reels and reports.\n\n" +
                "All pharmacy/prescription records including NDC numbers and drug information handouts/monographs.\n\n (Type \"I agree\")");
        if(!keyboard.nextLine().equals("I agree")){
            System.out.println("This form has been voided");
            System.exit(1);
        }

        String dateSpan;
        System.out.println("All billing records including all statements, insurance claim forms, itemized bills, and records of billing to third party" +
                " payers and payment or denial of benefits for the period (MM/DD/YYYY - MM/DD/YYYY)");
        dateSpan =  keyboard.nextLine();
        //PDF INPUT BELOW
        try {
            PDDocument pDDocument = PDDocument.load(new File("./Georgia-HIPAA-Medical-Release-Form.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("TO");
            field.setValue(providerName);
            field = pDAcroForm.getField("Street Address");
            field.setValue(address.substring(0, address.indexOf("-")));
            field = pDAcroForm.getField("City State and Zip Code");
            field.setValue(address.substring(address.indexOf("-") + 1));

            field = pDAcroForm.getField("Patient Name");
            field.setValue(demoUser.getName());
            field = pDAcroForm.getField("Date of Birth");
            field.setValue(demoUser.getDob());
            field = pDAcroForm.getField("Social Security Number");
            field.setValue(demoUser.getSocialSecurity());

            //check boxes
            field = pDAcroForm.getField("All medical records meaning every page in my record including but not limited to");
            field.setValue("On");
            field = pDAcroForm.getField("All physical occupational and rehab requests consultations and progress notes");
            field.setValue("On");
            field = pDAcroForm.getField("All disability Medicaid or Medicare records including claim forms and record of denial");
            field.setValue("On");
            field = pDAcroForm.getField("All employment personnel or wage records");
            field.setValue("On");
            field = pDAcroForm.getField("All autopsy laboratory histology cytology pathology immunohistochemistry records");
            field.setValue("On");
            field = pDAcroForm.getField("All pharmacyprescription records including NDC numbers and drug information");
            field.setValue("On");
            field = pDAcroForm.getField("All billing records including all statements insurance claim forms itemized bills and");
            field.setValue("On");

            field = pDAcroForm.getField("records of billing to third party payers and payment or denial of benefits for the period");
            field.setValue(dateSpan.substring(0, dateSpan.indexOf("-")));
            field = pDAcroForm.getField("to");
            field.setValue(dateSpan.substring(dateSpan.indexOf("-") + 1));

            field = pDAcroForm.getField("This protected health information is disclosed for the following purposes 2");
            field.setValue("To store my private medical records with Unify Medical.");

            field = pDAcroForm.getField("Name of Representative");
            field.setValue("Unify Medical");
            field = pDAcroForm.getField("Representative Capacity eg attorney records requestor agent etc");
            field.setValue("Record Requestor");
            field = pDAcroForm.getField("City State and Zip Code_2");
            field.setValue("Athens, GA 30601");
            field = pDAcroForm.getField("Street Address_2");
            field.setValue("123 Our Company St");

            pDDocument.save("./pdf-java-output.pdf");
            pDDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Thank you! Your form has been completed. \n" +
                "Please enter your providers email address to send this form to.");
        String providerEmail = keyboard.nextLine();
        System.out.println("Your forms should be in our system in 1-2 business days.");
    }
}
