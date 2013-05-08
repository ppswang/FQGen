package mystuff.fqgenerator;

import mystuff.fqgenerator.Clonal;

import java.io.File;
import java.io.FileInputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;

import org.biojava3.core.sequence.ProteinSequence;
import org.biojava3.core.sequence.compound.AminoAcidCompound;
import org.biojava3.core.sequence.compound.AminoAcidCompoundSet;
import org.biojava3.core.sequence.io.FastaReader;
import org.biojava3.core.sequence.io.FastaReaderHelper;
import org.biojava3.core.sequence.io.GenericFastaHeaderParser;
import org.biojava3.core.sequence.io.ProteinSequenceCreator;

public class FQGenerator {

	private static String src_genome;
	private static int read_depth;
	private static boolean paired_reads;
	private static String clone_str;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Variables
		File genome_fasta;
		
		// Load configuration file
		if (args.length == 0){
			System.out.println("Need to load a configuration file");
			System.exit(1);
		} else {
		
			// test of specified config file exists
			File file = new File(args[0]);
			if (file.exists()) {
//				System.out.println("config file exists");
			} else {
				System.out.println("config file doesn't exist");
				System.exit(1);
			}
			
			try {
				parse_config(args[0]); 
			} catch (IOException ex) {
				System.err.println("Caught IOException: "+ ex.getMessage());
			}
		}
		
        System.out.println("genome file:  " + src_genome);
        System.out.println("paired reads: " + paired_reads);
        System.out.println("read depth:   " + read_depth);
        System.out.println("clone pop:    " + clone_str);
		
		/**
		for (int i=0; i<args.length; i = i+1) {
			System.out.println(args[i]);
		}
	    File genome_fasta = new File(args[0]); 	
		if (genome_fasta.exists() == true) {
			System.out.println("File exists");
		} else {
			System.out.println("file not found");
		}
		**/
		System.out.println("Is this working?");
		System.exit(0);
		
	}

	
	private static void parse_config(String config) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(config));
		try {
			String line = br.readLine();
			while (line != null) {
				System.out.println("config line:\t"+line);
				if (line.startsWith("#")) {
					// do nothing
				} else if (line.startsWith("src_genome=")) {
					src_genome = line.substring(11);
				} else if (line.startsWith("paired_reads=")) {
					paired_reads = Boolean.parseBoolean(line.substring(13));
				} else if (line.startsWith("read_depth=")) {
					read_depth = Integer.parseInt(line.substring(11));
				} else if (line.startsWith("phylogeny=")) {
					clone_str = line.substring(10);
				}
				line = br.readLine();
			} // end of while (line)
		} finally {
			br.close();
		}
		System.out.println("finished loading config file");
	}
	
    private static int load_phylogeny(String phylo) {
    	
    	return 0;
    }
    
	
	
	
	
}
