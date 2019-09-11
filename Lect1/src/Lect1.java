import java.io.IOException;

public class Lect1 {

	public static void main(String[] args) throws IOException {
		byte[] buff = new byte[255];
		System.in.read(buff);
		System.out.println(new String(buff));

	}

}
