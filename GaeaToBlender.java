
import java.io.File;

class G2B_rename
{
	static Boolean
		REVERSE = false,
		INSPECT = false,
		RENAME = false,
		ENDING = false;
	
	static String 
		RENAMEVAL = null,
		ENDVAL = null;
	public static void main(String[] args)
	{
		String originalname = RENAMEVAL = args[0];
		String oldEnd;

		Boolean runnableCom = true;

		
		if (args[0].equals("-h") || args[1].equals("-h"))
		{
			runnableCom = false;
			System.out.println(	"\nCommands:\n -i, -inspect"+
								"\n -r, -rev, -reverse"+
								"\n -o <name>, -out <name>, -output <name>"+
								"\n -f <filetype>, -type <filetype>, -filetype <filetype>");
		}
		else
		{
			if(args.length > 1) {
				for(int i = 1; i < args.length; i++) {
					switch (args[i].toLowerCase()) {
						case "-i":
						case "-inspect":
							INSPECT = true;
							break;
						case "-r":
						case "-rev":
						case "-reverse":
							REVERSE = true;
							break;
						case "-o":
						case "-out":
						case "-output":
							RENAME = true;
							if (++i < args.length)
								RENAMEVAL = args[i];
							else
								System.out.println("Missing input entry for the renaming!");
							break;
						case "-f":
						case "-type":
						case "-filetype":
							ENDING = true;
							if (++i < args.length)
								ENDVAL = args[i];
							else
								System.out.println("Missing input entry for the end name!");
							break;
						default:
							runnableCom = false;
							System.out.println("\nFound false commands, try \n-h\n\nfor more information and commands\n");
							break;
					}
				}
			}
		}

		if (runnableCom)
		{
			System.out.println("\n[REVERSE="+REVERSE+"]\n[INSPECT="+INSPECT+"]\n");
		
			for (int yn = 0; yn < 8; yn++) {
				for (int xn = 0; xn < 8; xn++) {
					oldEnd = "_x00"+xn + "_y00"+yn+".png";
					if (REVERSE) {
						rename(originalname, oldEnd, xn, 7-yn);
					} else {
						rename(originalname, oldEnd, xn, yn);
					}
				}
			}
		}

		System.out.println("\nEnd \n");
	}
	
	//xn and yn goes from 0 to 7
	public static void rename(String originalname, String oldEnd, int xn, int yn)
	{
		String newEnd = "_10"+yn + ""+(xn+1) + ".png";
		String fullOldName = originalname + oldEnd;
		String fullNewName  = RENAMEVAL + newEnd;

		//looking for:
		File file = new File(fullOldName);

		//rename to:
		File file2 = new File(fullNewName);

		//if colliding file name:
		if (file2.exists()) {
			System.out.println(fullNewName +" already exists!");
		}

		//if found the file:
		if (file.exists()) {
			if(!INSPECT) {
				System.out.println(fullOldName + " - rename to: " + fullNewName);
				
				boolean success = file.renameTo(file2);

				if (!success) {
					System.out.print(" - Success!");
				}
			} else {
				System.out.println(" would rename "+fullOldName + " to: " + fullNewName);
			}
		}
	}
	
}
