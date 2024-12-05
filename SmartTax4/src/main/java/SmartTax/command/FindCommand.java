package SmartTax.command;

import lombok.Data;

@Data
public class FindCommand {
	String userId;
	String userEmail;
	String userPhone;
}
