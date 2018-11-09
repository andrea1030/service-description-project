package readCSV;

import java.io.FileReader;
import java.io.IOException;
import java.security.GeneralSecurityException;

import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;


public class ReadSVCregData {
    static final String CSV_FILENAME = "data.csv";
	public static void main(String[] args) throws IOException
	{
        try(ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(CSV_FILENAME), CsvPreference.STANDARD_PREFERENCE))
        {
            // the header elements are used to map the values to the bean
            final String[] headers = beanReader.getHeader(true);
            //final String[] headers = new String[]{"CustomerId","CustomerName","Country","PinCode","Email"};
            final CellProcessor[] processors = getProcessors();
 
//            Customer customer;
            SVCregData svcregdata;
            while ((svcregdata = beanReader.read(SVCregData.class, headers, processors)) != null) {
//                System.out.println(svcregdata);
            	  System.out.println(" "+svcregdata.getInterfaceType()+" "+svcregdata.getServiceCode()+" "+svcregdata.getActionId()+" "+svcregdata.getValue()+" "+svcregdata.getServiceDescription()+" "+svcregdata.getServiceFunctionName()+" "+svcregdata.getTargetURL()+" "+svcregdata.getMethod()+" "+svcregdata.getDataType()+" "+svcregdata.getDataDetails());
            }
        }
    }
 
    /**
     * Sets up the processors used for the examples.
     */
    private static CellProcessor[] getProcessors() {
//        final String emailRegex = "[a-z0-9\\._]+@[a-z0-9\\.]+";
//        		StrRegEx.registerMessage(emailRegex, "must be a valid email address");
        final String InterfaceTypeRegex = "^Touch|^Voice|^Remocon";
				StrRegEx.registerMessage(InterfaceTypeRegex, "must be a valid InterfaceType");
//		final String ServiceCodeRegex = "[";
//				StrRegEx.registerMessage(InterfaceTypeRegex, "must be a valid InterfaceType");
        
 
        final CellProcessor[] processors = new CellProcessor[] {
        		new StrRegEx(InterfaceTypeRegex), // InterfaceType: Touch, Voice, Remocon
//        		new NotNull(),
                new NotNull(), // ServiceCode: (Domain)(IType)(Service)(ID)
                new NotNull(), // ActionID: 15001
                new NotNull(), // Value: Slope
                new Optional(), // Service Description: ����Ʈ �δ�ü� ��ȭ��� 
                new NotNull(), // Service Function Name: CallResortInfoFunc
                new NotNull(), // Target URL
                new NotNull(), // Method
                new NotNull(), // Data Type
                new NotNull() // Data Details
        };
        return processors;
    }
}