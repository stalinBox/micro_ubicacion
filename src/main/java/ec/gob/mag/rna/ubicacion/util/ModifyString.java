package ec.gob.mag.rna.ubicacion.util;

public class ModifyString {
	public static String cleanBlanks(String str) {
		str= str.replaceAll(" +", " ");
		str= str.trim();
		return str;
	}
}
