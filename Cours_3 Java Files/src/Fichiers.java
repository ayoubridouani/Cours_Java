import java.awt.Color;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.JFrame;

//create + write on binary file
class CreateFichierBinaire{
	CreateFichierBinaire() throws IOException{
		FileOutputStream fos = new FileOutputStream("fichier.dat");
		DataOutputStream stream = new DataOutputStream(fos);
		stream.writeUTF("Hello world");
		stream.writeInt(10);
		stream.writeFloat(10.54f);
		stream.writeBoolean(true);
		System.out.println(stream.size());
		stream.close();
	}
}

//read from binary file
class LectureFichierBinaire{
	LectureFichierBinaire() throws IOException{
		DataInputStream stream = new DataInputStream(new FileInputStream("C:\\Users\\Anonsurf\\eclipse-workspace\\Les Fichiers\\fichier.dat"));
		System.out.println("La taille de fichier est : " + stream.available() + " octets");
		System.out.println(stream.readUTF());
		System.out.println(stream.readInt());
		System.out.println(stream.readFloat());
		System.out.println(stream.readBoolean());
		stream.close();
	}
}

//create + write on text file
class CreerFichierText{
	CreerFichierText() throws IOException{
		PrintWriter ecrire = new PrintWriter(new FileOutputStream("fichier.txt"));
		ecrire.println("Hello world");
		ecrire.println(10);
		ecrire.println(10.54f);
		ecrire.println(true);
		ecrire.close();
	}
}

//read from text file
class LectureFichierText{
	LectureFichierText() throws IOException{
		BufferedReader bfr = null;
		try{
			bfr = new BufferedReader(new FileReader("C:\\Users\\Anonsurf\\eclipse-workspace\\Les Fichiers\\fichier.txt"));
			String str;
			while((str = bfr.readLine()) != null)
				System.out.println(str);
		}catch(Exception e){
			System.out.print(e.getMessage());
		}finally{
			bfr.close();
		}
	}
}

//scan a directory with max-depth=1
class ScanRepertoire{
	ScanRepertoire(){
		String nomFichier;
		File repertoire = new File(".");
		if(repertoire.isDirectory()) {
			String [] tab = repertoire.list();
			for(int i=0;i<tab.length;i++) {
				nomFichier = tab[i];
				File fich = new File(nomFichier);
				if(fich.isFile()){
					Date dt = new Date(fich.lastModified());
					long taille = fich.length();
					System.out.println(nomFichier + "\t" + taille + "\t" + dt);
				}
			}
		}
	}
}

//scan a directory with max-depth=infinite
class Tree{
	public void scanDirectory(String data) throws IOException{
		String chemin = data;
		String nomFichier;
		File repertoire = new File(data);
		if(repertoire.isDirectory()) {
			String [] tab = repertoire.list();
			for(int i=0;i<tab.length;i++) {
				nomFichier = tab[i];
				File fich = new File(nomFichier);
				if(fich.isFile()){
					System.out.println(chemin + nomFichier);
				}else {
					chemin += "\\" + nomFichier; 
					System.out.println(chemin);
					scanDirectory(chemin);
				}
			}
		}
	}
}

//access to file with technique in C
class AccessFile{
	AccessFile() throws IOException{
		File ch = new File("result.txt");
		RandomAccessFile fiche = new RandomAccessFile(ch,"rw");
		int nb;
		for(int i=0;i<10;i++) fiche.writeInt(i*i);
		//fiche.seek(6); //error
		fiche.seek(8);
		fiche.writeInt(100);
		fiche.seek(0);
		for(int i=0;i<10;i++) {
			nb = fiche.readInt();
			System.out.println(nb);
		}
		fiche.close();
	}
}

//compressed file
class Zipper{
	Zipper() throws IOException{
		ZipOutputStream archive = new ZipOutputStream(new FileOutputStream("archive.zip"));
		PrintWriter fichier = new PrintWriter(archive,true);
		archive.putNextEntry(new ZipEntry("Premier.txt"));
		fichier.println("Il s'agit juste");
		fichier.println("d'un premier texte");
		archive.putNextEntry(new ZipEntry("deuxieme.txt"));
		fichier.println("Il s'agit juste");
		fichier.println("d'un deuxieme texte");
		fichier.close();
	}
}

//Access to File
class AccessFilePath{
	AccessFilePath() throws IOException{
		Path homePath = Paths.get(System.getProperty("user.home"));
		try(DirectoryStream<Path> flot = Files.newDirectoryStream(homePath)) {
			for(Path elem : flot) {
				System.out.println(elem);
			}
		}
		try(DirectoryStream<Path> flot = Files.newDirectoryStream(homePath,"*.{java,jsp,xml}")) {
			for(Path elem : flot) {
				System.out.println(elem);
			}
		}
	}
}

//read File with BufferReader
class readFileBufferReader{
	readFileBufferReader() throws IOException{
		Path pt = Paths.get("C:\\Users\\Anonsurf\\Desktop\\test.txt");
		try(BufferedReader br = Files.newBufferedReader(pt)) {
			String ligne = null;
			while((ligne = br.readLine()) != null) {
				System.out.println(ligne);
			}
		}
	}
}

//write in file with BufferedWrite
class writeFileCharset{
	writeFileCharset() throws IOException{
		Charset utf8 = Charset.forName("UTF-8");
		Path pt = Paths.get("C:\\Users\\Anonsurf\\Desktop\\test.txt");
		String text = "\nhello world�";
		try(BufferedWriter bw = Files.newBufferedWriter(pt,utf8,StandardOpenOption.CREATE,StandardOpenOption.APPEND)){
			bw.write(text);
		}
	}
}

//get All sectors Machine
class getSecteurs{
	getSecteurs(){
		Iterable<Path> lecteurs = FileSystems.getDefault().getRootDirectories();
		for (Path nom : lecteurs) {
			System.out.println(nom);
		}
	}
}

//get All sectors Machine + details
class getSecteursDetails{
	getSecteursDetails() throws IOException{
		try(FileSystem defaultFS = FileSystems.getDefault()){
			Iterable<Path> lecteurs = FileSystems.getDefault().getRootDirectories();
			for (Path nom : lecteurs) {
				System.out.println(nom);
				try{
					FileStore fs = Files.getFileStore(nom);
					long et = fs.getTotalSpace();
					long ed = fs.getUsableSpace();
					System.out.printf("Taille %2f\n",et/1073741824.0);
					System.out.printf("Espace Disponible %2f\n",ed/1073741824.0);
				}catch(Exception e) {
					System.out.print(e);
				}

			}
		}
	}
}

@SuppressWarnings("serial")
class swingS extends JFrame{
	swingS(){
		setSize(350,350);
		setVisible(true);
		FlowLayout fl = new FlowLayout();
		setLayout(fl);
		setBackground(Color.cyan);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

//function main :)
public class Fichiers {
	public static void main(String args[]) throws IOException {
		//new CreateFichierBinaire();
		//new LectureFichierBinaire();
		//new CreerFichierText();
		//new LectureFichierText();
		//new ScanRepertoire();
		//new Tree().scanDirectory("C:\\Users\\Anonsurf");
		//new Zipper();
		//new AccessFilePath();
		//new readFileBufferReader();
		//new writeFileCharset();
		//new getSecteurs();
		//new getSecteursDetails();
		new swingS();
	}
}
