package funcWriteCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.ParseLong;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

public class TestWriteCSV {
    private static List<SVCregData> svcregdata = new ArrayList<SVCregData>();
    
    static
    {
    	svcregdata.add(new SVCregData("Remocon", "SR030005", "15500", "BedRoomLight", "침실조명끄기 리모콘제어", "ReShopTurnOffLightFunc", "https://api.yanolja.io/ui/zGgtel54D", "GET", "JSON", "KT STD"));
    	svcregdata.add(new SVCregData("Voice", "RV010001", "15001", "Slope", "리조트 슬로프정보 발화", "CallResortInfoFunc", "https://api.yanolja.io/ui/zGgtel54D", "GET", "JSON", "KTSTD"));
//    	svcregdata.add(new SVCregData(3, "Paul", "USA", 52345345L, "paul@gmail.com"));
    }
     
    private static CellProcessor[] getProcessors() {
//      final String emailRegex = "[a-z0-9\\._]+@[a-z0-9\\.]+";
//      		StrRegEx.registerMessage(emailRegex, "must be a valid email address");
      final String InterfaceTypeRegex = "^Touch|^Voice|^Remocon";
				StrRegEx.registerMessage(InterfaceTypeRegex, "must be a valid InterfaceType");
//		final String ServiceCodeRegex = "[";
//				StrRegEx.registerMessage(InterfaceTypeRegex, "must be a valid InterfaceType");
      

      final CellProcessor[] processors = new CellProcessor[] {
      		new StrRegEx(InterfaceTypeRegex), // InterfaceType: Touch, Voice, Remocon
//      		new NotNull(),
              new NotNull(), // ServiceCode: (Domain)(IType)(Service)(ID)
              new NotNull(), // ActionID: 15001
              new NotNull(), // Value: Slope
              new Optional(), // Service Description:
              new NotNull(), // Service Function Name: CallResortInfoFunc
              new NotNull(), // Target URL
              new NotNull(), // Method
              new NotNull(), // Data Type
              new NotNull() // Data Details
      };
      return processors;
  }

     
    public static void main(String[] args)
    {
         
        ICsvBeanWriter beanWriter = null;
         
        try
        {
            beanWriter = new CsvBeanWriter(new FileWriter("temp3.csv"), CsvPreference.STANDARD_PREFERENCE);
            final String[] header = new String[] { "InterfaceType", "ServiceCode", "ActionId", "Value" ,"ServiceDescription", "ServiceFunctionName", "TargetURL", "Method", "DataType", "DataDetails" };
 
            final CellProcessor[] processors = getProcessors();
 
            // write the header
            beanWriter.writeHeader(header);
 
            // write the beans data
            for (SVCregData c : svcregdata) {
                beanWriter.write(c, header, processors);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            try {
                beanWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
