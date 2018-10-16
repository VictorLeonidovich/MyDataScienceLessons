package obtainingandcleaning.lesson01p10;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class TestRecursiveDirectorytraversal {
	private final static String PATH = "supportingFiles/obtainingandcleaning/lesson01/test";

	public static void main(String[] args) {
		System.out.println(listFiles(new File(PATH)));
	}

	private static Set<File> listFiles(File rootDir) {
		Set<File> fileSet = new HashSet<>();
		if (rootDir == null || rootDir.listFiles() == null) {
			return fileSet;
		}
		for (File fileOrDir : rootDir.listFiles()) {
			if (fileOrDir.isFile()) {
				fileSet.add(fileOrDir);
			} else {
				fileSet.addAll(listFiles(fileOrDir));
			}
		}
		return fileSet;
	}
}
