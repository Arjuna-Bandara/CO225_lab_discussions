import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;

public class Copy extends GenericCommand {

	/*
	 * Copy accept 2 paramenters, #file #destination
	 */
	public void handleCommand(String[] args) {

		if (!args[0].equals("copy")){
			someThingWrong();
		}
			

		if (args.length < 2) {
			System.out.println("Usage: copy");
			System.out.println("copy file_source file_destination ");
			return;
		}

		if (args[0].equals("copy")) {
			copyFile(args[1], args[2]);
			
		}



	}

	public void copyFile(String source, String destination) {
		File sourceFile = new File(source);
		File destinationFile = new File(destination);
				
		if (source == destination) {
			System.out.println("need different file name");			
		}
		try {
			copyFileUsingJava7Files(sourceFile, destinationFile);
			System.out.println("File written ");
			commandCompleted();

		} catch (Exception e) {
			System.err.println(e);
		}
	}

	private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
		Files.copy(source.toPath(), dest.toPath()); //support java 7 onwards 
	}

}