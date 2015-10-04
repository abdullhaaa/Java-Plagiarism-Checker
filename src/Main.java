
import java.io.IOException;
import java.net.URI;
import org.json.JSONException;

import copyleaks.sdk.api.Scanner;
import copyleaks.sdk.api.exceptions.CommandFailedException;
import copyleaks.sdk.api.models.ResultRecord;

public class Main
{

	public static void main(String[] args)
			throws IOException, JSONException, CommandFailedException
	{
		// For more information, visit Copyleaks How-To page:
		// https://api.copyleaks.com/Guides/HowToUse

		// Creating Copyleaks account: https://copyleaks.com/Account/Signup
		// Use your account information:
		String username = "<Your-Username>";

		// Generate your API Key --> https://copyleaks.com/Account/Manage
		String APIKey = "<Your-Key>"; 

		Scanner scanner = new Scanner(username, APIKey);

		try
		{
			ResultRecord[] results = scanner.ScanUrl(new URI("<Path-To-File>"));
			// Another scanning option --> scanner.ScanLocalTextualFile(file)

			if (results.length == 0)
			{
				System.out.println("\tNo results.");
			}
			else
			{
				for (int i = 0; i < results.length; ++i)
				{
					System.out.println();
					System.out.println(String.format("Result %1$s:", i + 1));
					System.out.println(String.format("Domain: %1$s", results[i].getDomain()));
					System.out.println(String.format("Url: %1$s", results[i].getURL()));
					System.out.println(String.format("Precents: %1$s", results[i].getPrecents()));
					System.out.println(String.format("CopiedWords: %1$s", results[i].getNumberOfCopiedWords()));
				}
			}
		}
		catch (Exception ex)
		{
			System.out.println("\tFailed!");
			System.out.println("Unhandled Exception");
			System.out.println(ex);
		}
	}
}