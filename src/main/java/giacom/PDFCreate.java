package giacom;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PDFCreate {

    User patient;

    public PDFCreate(String provider, String address1, String address2, User demoUser,
                     String socialSecurity, String startDate, String endDate){
        patient = demoUser;
        try {
            PDDocument pDDocument = PDDocument.load(new File("./Georgia-HIPAA-Medical-Release-Form.pdf"));
            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();
            PDField field = pDAcroForm.getField("TO");
            field.setValue(provider);
            field = pDAcroForm.getField("Street Address");
            field.setValue(address1);
            field = pDAcroForm.getField("City State and Zip Code");
            field.setValue(address2);

            field = pDAcroForm.getField("Patient Name");
            field.setValue(demoUser.getName());
            field = pDAcroForm.getField("Date of Birth");
            field.setValue(demoUser.getDob());
            field = pDAcroForm.getField("Social Security Number");
            field.setValue(socialSecurity);

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
            field.setValue(startDate);
            field = pDAcroForm.getField("to");
            field.setValue(endDate);

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

        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("./pdf-java-output.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                // no application registered for PDFs
            }
        }

    }
}
