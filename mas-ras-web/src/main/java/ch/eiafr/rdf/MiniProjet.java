package ch.eiafr.rdf;

import org.eclipse.rdf4j.model.IRI;
import org.eclipse.rdf4j.model.ValueFactory;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.XMLSchema;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.sail.SailRepository;
import org.eclipse.rdf4j.sail.memory.MemoryStore;

public class MiniProjet 
{
	// namespaces
	static String namespaceOnto = "http://music-is-the-answer.com/ontology/";
	static String namespaceReso = "http://music-is-the-answer.com/resource/";

	// classes
	static IRI Artist;
	static IRI Band;
	static IRI Performer;
	static IRI Contract;
	static IRI Label;
	static IRI Performance;
	static IRI Rehearsal;
	static IRI Recording;
	static IRI Concert;
	static IRI Studio;
	static IRI Event;
	static IRI Release;
	static IRI Track;
	static IRI Album;
	static IRI Platform;

	// object properties
	static IRI plays_in;
	static IRI signs;
	static IRI offers;
	static IRI creates;
	static IRI publishes;
	static IRI performs_in;
	static IRI rehearses_in;
	static IRI takes_place_in_1;	// rehearsal
	static IRI takes_place_in_2;	// recording
	static IRI takes_place_in_3;	// concert
	static IRI rents;
	static IRI appears_on;
	static IRI is_sold_on;
	
	// data properties
	static IRI hasFirstName;
	static IRI hasLastName;
	static IRI hasStageName;
	static IRI hasGenre;
	static IRI isSignedOn;
	static IRI hasAmountInDollars;
	static IRI hasDeliverable;
	static IRI isFoundedBy;
	static IRI hasName;
	static IRI occursOn;
	static IRI isLocatedAt;
	static IRI hasDailyRentalPriceInDollars;
	static IRI paysFeeInDollars;
	static IRI hasLengthInSec;
	static IRI isReleasedOn;
	static IRI hasTitle;
	static IRI supportsFormat;
	static IRI hasCountryCode;
	
	// individuals
	static IRI performer_1;
	static IRI performer_2;
	static IRI band_1;
	static IRI band_2;
	static IRI label_1;
	static IRI label_2;
	static IRI contract_1;
	static IRI contract_2;
	static IRI recording_1;
	static IRI recording_2;
	static IRI concert_1;
	static IRI concert_2;
	static IRI Bear_Creek;
	static IRI Rockfield;
	static IRI NY_Tour_Date;
	static IRI Warm_Up_Gig;
	static IRI track_1;
	static IRI track_2;
	static IRI album_1;
	static IRI album_2;
	static IRI iTunes;
	static IRI Juno;
	
	static void buildOntology(ValueFactory f) 
	{
		// classes
		Artist 		= f.createIRI(namespaceOnto, "Artist");
		Band 		= f.createIRI(namespaceOnto, "Band");
		Performer 	= f.createIRI(namespaceOnto, "Performer");
		Contract 	= f.createIRI(namespaceOnto, "Contract");
		Label 		= f.createIRI(namespaceOnto, "Label");
		Performance = f.createIRI(namespaceOnto, "Performance");
		Rehearsal 	= f.createIRI(namespaceOnto, "Rehearsal");
		Recording 	= f.createIRI(namespaceOnto, "Recording");
		Concert 	= f.createIRI(namespaceOnto, "Concert");
		Studio 		= f.createIRI(namespaceOnto, "Studio");
		Event 		= f.createIRI(namespaceOnto, "Event");
		Release 	= f.createIRI(namespaceOnto, "Release");
		Track 		= f.createIRI(namespaceOnto, "Track");
		Album 		= f.createIRI(namespaceOnto, "Album");
		Platform 	= f.createIRI(namespaceOnto, "Platform");
		
		// object properties
		plays_in			= f.createIRI(namespaceOnto, "plays_in");
		signs				= f.createIRI(namespaceOnto, "signs");
		offers				= f.createIRI(namespaceOnto, "offers");
		creates				= f.createIRI(namespaceOnto, "creates");
		publishes			= f.createIRI(namespaceOnto, "publishes");
		performs_in			= f.createIRI(namespaceOnto, "performs_in");
		rehearses_in		= f.createIRI(namespaceOnto, "rehearses_in");
		takes_place_in_1	= f.createIRI(namespaceOnto, "takes_place_in_1");	// rehearsal
		takes_place_in_2	= f.createIRI(namespaceOnto, "takes_place_in_2");	// recording
		takes_place_in_3	= f.createIRI(namespaceOnto, "takes_place_in_3");	// concert
		rents				= f.createIRI(namespaceOnto, "rents");
		appears_on			= f.createIRI(namespaceOnto, "appears_on");
		is_sold_on			= f.createIRI(namespaceOnto, "is_sold_on");

		// data properties
		hasFirstName					= f.createIRI(namespaceOnto, "hasFirstName");
		hasLastName						= f.createIRI(namespaceOnto, "hasLastName");
		hasStageName					= f.createIRI(namespaceOnto, "hasStageName");
		hasGenre						= f.createIRI(namespaceOnto, "hasGenre");
		isSignedOn						= f.createIRI(namespaceOnto, "isSignedOn");
		hasAmountInDollars				= f.createIRI(namespaceOnto, "hasAmountInDollars");
		hasDeliverable					= f.createIRI(namespaceOnto, "hasDeliverable");
		isFoundedBy						= f.createIRI(namespaceOnto, "isFoundedBy");
		hasName							= f.createIRI(namespaceOnto, "hasName");
		occursOn						= f.createIRI(namespaceOnto, "occursOn");
		isLocatedAt						= f.createIRI(namespaceOnto, "isLocatedAt");
		hasDailyRentalPriceInDollars	= f.createIRI(namespaceOnto, "hasDailyRentalPriceInDollars");
		paysFeeInDollars				= f.createIRI(namespaceOnto, "paysFeeInDollars");
		hasLengthInSec					= f.createIRI(namespaceOnto, "hasLengthInSec");
		isReleasedOn					= f.createIRI(namespaceOnto, "isReleasedOn");
		hasTitle						= f.createIRI(namespaceOnto, "hasTitle");
		supportsFormat					= f.createIRI(namespaceOnto, "supportsFormat");
		hasCountryCode					= f.createIRI(namespaceOnto, "hasCountryCode");
		
		// individuals
		performer_1   	= f.createIRI(namespaceReso, "performer_1");  
		performer_2   	= f.createIRI(namespaceReso, "performer_2"); 
		band_1      	= f.createIRI(namespaceReso, "band_1");          
		band_2      	= f.createIRI(namespaceReso, "band_2");          
		label_1     	= f.createIRI(namespaceReso, "label_1");         
		label_2     	= f.createIRI(namespaceReso, "label_2");         
		contract_1  	= f.createIRI(namespaceReso, "contract_1");      
		contract_2  	= f.createIRI(namespaceReso, "contract_2");      
		recording_1 	= f.createIRI(namespaceReso, "recording_1");     
		recording_2 	= f.createIRI(namespaceReso, "recording_2");     
		concert_1   	= f.createIRI(namespaceReso, "concert_1");       
		concert_2   	= f.createIRI(namespaceReso, "concert_2");       
		Bear_Creek  	= f.createIRI(namespaceReso, "Bear_Creek");      
		Rockfield   	= f.createIRI(namespaceReso, "Rockfield");       
		NY_Tour_Date	= f.createIRI(namespaceReso, "NY_Tour_Date");    
		Warm_Up_Gig 	= f.createIRI(namespaceReso, "Warm_Up_Gig");     
		track_1     	= f.createIRI(namespaceReso, "track_1");         
		track_2     	= f.createIRI(namespaceReso, "track_2");         
		album_1     	= f.createIRI(namespaceReso, "album_1");         
		album_2     	= f.createIRI(namespaceReso, "album_2");         
		iTunes      	= f.createIRI(namespaceReso, "iTunes");          
		Juno        	= f.createIRI(namespaceReso, "Juno");            
	}                                       
		
	static void createIndividualsPerformer(ValueFactory f, RepositoryConnection conn, IRI performer, String firstName, String lastName, String stageName, String genre, IRI band) 
	{	
		conn.add(performer, RDF.TYPE, Performer);
		conn.add(performer, hasFirstName, f.createLiteral(firstName, XMLSchema.STRING));
		conn.add(performer, hasLastName, f.createLiteral(lastName, XMLSchema.STRING));
		conn.add(performer, hasStageName, f.createLiteral(stageName != "" ? stageName : firstName + " " + lastName, XMLSchema.STRING));
		conn.add(performer, hasGenre, f.createLiteral(genre, XMLSchema.STRING));
		conn.add(performer, plays_in, band);
	}
	
	static void createIndividualsBand(ValueFactory f, RepositoryConnection conn, IRI band, String stageName, String genre, IRI concert, IRI recording, IRI track, IRI contract) 
	{
		conn.add(band, RDF.TYPE, Band);
		conn.add(band, hasStageName,  f.createLiteral(stageName, XMLSchema.STRING));
		conn.add(band, hasGenre,  f.createLiteral(genre, XMLSchema.STRING));
		conn.add(band, performs_in, concert);
		conn.add(band, performs_in, recording);
		conn.add(band, creates, track);
		conn.add(band, signs, contract);
	}
	
	static void createIndividualsLabel(ValueFactory f, RepositoryConnection conn, IRI label, String founder, String name, IRI contract, IRI release, IRI studio) 
	{	
		conn.add(label, RDF.TYPE, Label);
		conn.add(label, isFoundedBy,  f.createLiteral(founder, XMLSchema.STRING));
		conn.add(label, hasName,  f.createLiteral(name, XMLSchema.STRING));
		conn.add(label, offers, contract);
		conn.add(label, publishes, release);
		conn.add(label, rents, studio);
	}
	
	static void createIndividualsContract(ValueFactory f, RepositoryConnection conn, IRI contract, String date, String amount, String deliverable) 
	{
		conn.add(contract, RDF.TYPE, Contract);
		conn.add(contract, isSignedOn,  f.createLiteral(date, XMLSchema.DATETIME));
		conn.add(contract, hasAmountInDollars,  f.createLiteral(amount, XMLSchema.DOUBLE));
		conn.add(contract, hasDeliverable,  f.createLiteral(deliverable, XMLSchema.STRING));
	}
	
	static void createIndividualsRehearsal(ValueFactory f, RepositoryConnection conn, IRI rehearsal, String date, String name, IRI studio) 
	{
		conn.add(rehearsal, RDF.TYPE, Rehearsal);
		conn.add(rehearsal, occursOn,  f.createLiteral(date, XMLSchema.DATETIME));
		conn.add(rehearsal, hasName,  f.createLiteral(name, XMLSchema.STRING));
		conn.add(rehearsal, takes_place_in_1, studio);
	}
	
	static void createIndividualsRecording(ValueFactory f, RepositoryConnection conn, IRI recording, String date, String name, IRI studio) 
	{
		conn.add(recording, RDF.TYPE, Recording);
		conn.add(recording, occursOn,  f.createLiteral(date, XMLSchema.DATETIME));
		conn.add(recording, hasName,  f.createLiteral(name, XMLSchema.STRING));
		conn.add(recording, takes_place_in_2, studio);
	}
	
	static void createIndividualsConcert(ValueFactory f, RepositoryConnection conn, IRI concert, String date, String name, IRI event) 
	{
		conn.add(concert, RDF.TYPE, Concert);
		conn.add(concert, occursOn,  f.createLiteral(date, XMLSchema.DATETIME));
		conn.add(concert, hasName,  f.createLiteral(name, XMLSchema.STRING));
		conn.add(concert, takes_place_in_3, event);
	}
	
	static void createIndividualsStudio(ValueFactory f, RepositoryConnection conn, IRI studio, String location, String rentalPrice) 
	{
		conn.add(studio, RDF.TYPE, Studio);
		conn.add(studio, isLocatedAt,  f.createLiteral(location, XMLSchema.STRING));
		conn.add(studio, hasDailyRentalPriceInDollars,  f.createLiteral(rentalPrice, XMLSchema.DOUBLE));
	}
	
	static void createIndividualsEvent(ValueFactory f, RepositoryConnection conn, IRI event, String location, String fee) 
	{
		conn.add(event, RDF.TYPE, Event);
		conn.add(event, isLocatedAt,  f.createLiteral(location, XMLSchema.STRING));
		conn.add(event, paysFeeInDollars,  f.createLiteral(fee, XMLSchema.DOUBLE));
	}
	
	static void createIndividualsTrack(ValueFactory f, RepositoryConnection conn, IRI track, String date, String title, String length, IRI album) 
	{
		conn.add(track, RDF.TYPE, Track);
		conn.add(track, isReleasedOn,  f.createLiteral(date, XMLSchema.DATETIME));
		conn.add(track, hasTitle,  f.createLiteral(title, XMLSchema.STRING));
		conn.add(track, hasLengthInSec,  f.createLiteral(length, XMLSchema.DOUBLE));
		conn.add(track, appears_on, album);
	}

	static void createIndividualsAlbum(ValueFactory f, RepositoryConnection conn, IRI album, String date, String title, String length, IRI platform) 
	{	
		conn.add(album, RDF.TYPE, Album);
		conn.add(album, isReleasedOn,  f.createLiteral(date, XMLSchema.DATETIME));
		conn.add(album, hasTitle,  f.createLiteral(title, XMLSchema.STRING));
		conn.add(album, hasLengthInSec,  f.createLiteral(length, XMLSchema.DOUBLE));
		conn.add(album, is_sold_on, platform);
	}
	
	static void createIndividualsPlatform(ValueFactory f, RepositoryConnection conn, IRI platform, String[] formats, String countryCode) 
	{
		conn.add(platform, RDF.TYPE, Platform);
		for (String format: formats) 
		{
			conn.add(platform, supportsFormat,  f.createLiteral(format, XMLSchema.STRING));
		}
		conn.add(platform, hasCountryCode,  f.createLiteral(countryCode, XMLSchema.STRING));
	}
	
	static void createIndividuals(ValueFactory f, RepositoryConnection conn) 
	{
		createIndividualsPerformer(f, conn, performer_1, "Dave", "Grohl", "", "grunge", band_1);
		createIndividualsPerformer(f, conn, performer_2, "Noel", "Gallagher", "", "rock", band_2);
		
		createIndividualsBand(f, conn, band_1, "Foo Fighters", "grunge", concert_1, recording_1, track_1, contract_1);
		createIndividualsBand(f, conn, band_2, "Oasis", "rock", concert_2, recording_2, track_2, contract_2);
		
		createIndividualsLabel(f, conn, label_1, "Johnny Mercer", "Capitol", contract_1, album_1, Bear_Creek);
		createIndividualsLabel(f, conn, label_2, "Alan McGee", "Creation", contract_2, album_2, Rockfield);
		
		createIndividualsContract(f, conn, contract_1, "01.01.1996", "5000000", "2 albums");
		createIndividualsContract(f, conn, contract_2, "02.02.1995", "2700000", "1 album");
		
		createIndividualsRecording(f, conn, recording_1, "01.02.1997", "Take 4", Bear_Creek);
		createIndividualsRecording(f, conn, recording_2, "26.08.1995", "Take 3", Rockfield);
		
		createIndividualsConcert(f, conn, concert_1, "06.10.1997", "Tour", NY_Tour_Date);
		createIndividualsConcert(f, conn, concert_2, "22.06.1995", "Glastonbury", Warm_Up_Gig);
		
		createIndividualsStudio(f, conn, Bear_Creek, "Woodinville", "50000");
		createIndividualsStudio(f, conn, Rockfield, "Monmouth", "26000");
		
		createIndividualsEvent(f, conn, NY_Tour_Date, "Roseland Ballroom", "500000");
		createIndividualsEvent(f, conn, Warm_Up_Gig, "Bath Pavilion", "360000");
		
		createIndividualsTrack(f, conn, track_1, "20.05.1997", "Everlong", "250", album_1);
		createIndividualsTrack(f, conn, track_2, "02.10.1995", "Wonderwall", "258", album_2);
		
		createIndividualsAlbum(f, conn, album_1, "20.05.1997", "The Colour and the Shape", "", iTunes);
		createIndividualsAlbum(f, conn, album_2, "02.10.1995", "(What's the Story) Morning Glory?", "", Juno);
		
		createIndividualsPlatform(f, conn, iTunes, new String[]{"mp3", "wav"}, "US");
		createIndividualsPlatform(f, conn, Juno, new String[]{"mp3", "flac"}, "UK");
	}
	
	static void execQueryGetPerformers(RepositoryConnection conn) 
	{	
	    String queryString = "PREFIX res: <http://music-is-the-answer.com/resource/> \n";
	    queryString += "PREFIX mu: <http://music-is-the-answer.com/ontology/> \n";
	    queryString += "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n";
	    queryString += "SELECT ?firstname ?lastname \n";
	    queryString += "WHERE { \n";
	    queryString += "	?performer rdf:type mu:Performer . \n";
	    queryString += "    ?performer mu:hasFirstName ?firstname . \n";
	    queryString += "    ?performer mu:hasLastName ?lastname . \n";
	    queryString += "}";
	    TupleQuery query = conn.prepareTupleQuery(queryString); 

	    try (TupleQueryResult result = query.evaluate()) 
	    {
	    	System.out.println("Query 1 - The firstname and lastname of all performers:");
			while (result.hasNext()) 
			{
			    BindingSet solution = result.next();
			    System.out.println("performer: " + solution.getValue("firstname") + " " + solution.getValue("lastname"));
			}
			System.out.println();
	    }
	}
	
	static void execQueryGetPlatforms(RepositoryConnection conn) 
	{	
	    String queryString = "PREFIX res: <http://music-is-the-answer.com/resource/> \n";
	    queryString += "PREFIX mu: <http://music-is-the-answer.com/ontology/> \n";
	    queryString += "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n";
	    queryString += "SELECT ?platform \n";
	    queryString += "WHERE { \n";
	    queryString += "	?platform rdf:type mu:Platform . \n";
	    queryString += "    { \n";
	    queryString += "    	?platform mu:supportsFormat \"flac\" . \n";
	    queryString += "    } \n";
	    queryString += "    UNION \n";
	    queryString += "    { \n";
	    queryString += "    	?platform mu:supportsFormat \"wav\" . \n";
	    queryString += "    } \n";
	    queryString += "}";
	    TupleQuery query = conn.prepareTupleQuery(queryString); 

	    try (TupleQueryResult result = query.evaluate()) 
	    {
	    	System.out.println("Query 2 - The platforms which support either flac or wav:");
			while (result.hasNext()) 
			{
			    BindingSet solution = result.next();
			    System.out.println(solution.getValue("platform"));
			}
			System.out.println();
	    }
	}
	
	static void execQueryGetLabels(RepositoryConnection conn) 
	{	
	    String queryString = "PREFIX res: <http://music-is-the-answer.com/resource/> \n";
	    queryString += "PREFIX mu: <http://music-is-the-answer.com/ontology/> \n";
	    queryString += "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n";
	    queryString += "SELECT ?name ?ceo \n";
	    queryString += "WHERE { \n";
	    queryString += "	?label rdf:type mu:Label . \n";
	    queryString += "    ?label mu:hasName ?name . \n";
	    queryString += "    OPTIONAL \n";
	    queryString += "    { \n";
	    queryString += "    	?label mu:isFoundedBy ?ceo . \n";
	    queryString += "    } \n";
	    queryString += "} ORDER BY ?name";
	    TupleQuery query = conn.prepareTupleQuery(queryString); 

	    try (TupleQueryResult result = query.evaluate()) 
	    {
	    	System.out.println("Query 3 - The name of the labels and the name of their founder (if known):");
			while (result.hasNext()) 
			{
			    BindingSet solution = result.next();
			    System.out.println("platform's name: " + solution.getValue("name") + " ; platform's founder: " + solution.getValue("ceo"));
			}
			System.out.println();
	    }
	}
	
	static void execQueryGetTracks(RepositoryConnection conn, String albumTitle, String bandName) 
	{	
	    String queryString = "PREFIX res: <http://music-is-the-answer.com/resource/> \n";
	    queryString += "PREFIX mu: <http://music-is-the-answer.com/ontology/> \n";
	    queryString += "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n";
	    queryString += "SELECT ?title \n";
	    queryString += "WHERE { \n";
	    queryString += "	?track rdf:type mu:Track . \n";
	    queryString += "    ?track mu:hasTitle ?title . \n";
	    queryString += "    ?track mu:appears_on ?album . \n";
	    queryString += "    ?album mu:hasTitle ?albumTitle . \n";
	    queryString += "    ?band mu:creates ?track . \n";
	    queryString += "    ?band mu:hasStageName ?stageName . \n";
	    queryString += "    FILTER( ?albumTitle = \"" + albumTitle + "\" ) \n";
	    queryString += "    FILTER( ?stageName = \"" + bandName + "\" ) \n";
	    queryString += "} ORDER BY ?title";
	    TupleQuery query = conn.prepareTupleQuery(queryString); 

	    try (TupleQueryResult result = query.evaluate()) 
	    {
	    	System.out.println("Query 4 - The titles of the tracks on the given album and created by the given artist:");
			while (result.hasNext()) 
			{
			    BindingSet solution = result.next();
			    System.out.println("track: " + solution.getValue("title"));
			}
			System.out.println();
	    }
	}
	
	static void execQueryGetTracksVariant(RepositoryConnection conn, String albumTitle, String bandResource) 
	{	
	    String queryString = "PREFIX res: <http://music-is-the-answer.com/resource/> \n";
	    queryString += "PREFIX mu: <http://music-is-the-answer.com/ontology/> \n";
	    queryString += "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n";
	    queryString += "SELECT ?title \n";
	    queryString += "WHERE { \n";
	    queryString += "	?track rdf:type mu:Track . \n";
	    queryString += "    ?track mu:hasTitle ?title . \n";
	    queryString += "    ?track mu:appears_on ?album . \n";
	    queryString += "    ?album mu:hasTitle ?albumTitle . \n";
	    queryString +=      bandResource + " mu:creates ?track . \n";
	    queryString += "    FILTER( ?albumTitle = \"" + albumTitle + "\" ) \n";
	    queryString += "} ORDER BY ?title";
	    TupleQuery query = conn.prepareTupleQuery(queryString); 

	    try (TupleQueryResult result = query.evaluate()) 
	    {
	    	System.out.println("Query 4 (variant) - The titles of the tracks on the given album and created by the given artist:");
			while (result.hasNext()) 
			{
			    BindingSet solution = result.next();
			    System.out.println("track: " + solution.getValue("title"));
			}
			System.out.println();
	    }
	}
	
	static void execQueryGetBandsInLabel(RepositoryConnection conn, String labelName) 
	{	
	    String queryString = "PREFIX res: <http://music-is-the-answer.com/resource/> \n";
	    queryString += "PREFIX mu: <http://music-is-the-answer.com/ontology/> \n";
	    queryString += "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n";
	    queryString += "SELECT ?name \n";
	    queryString += "WHERE { \n";
	    queryString += "	?band rdf:type mu:Band . \n";
	    queryString += "    ?band mu:hasStageName ?name . \n";
	    queryString += "    ?band mu:signs ?contract . \n";
	    queryString += "    ?label mu:offers ?contract . \n";
	    queryString += "    ?label mu:hasName ?labelname . \n";
	    queryString += "    FILTER( ?labelname = \"" + labelName + "\" ) \n";
	    queryString += "} ORDER BY ?name";
	    TupleQuery query = conn.prepareTupleQuery(queryString); 

	    try (TupleQueryResult result = query.evaluate()) 
	    {
	    	System.out.println("Query 5 - The bands who signed a contract with the given label:");
			while (result.hasNext()) 
			{
			    BindingSet solution = result.next();
			    System.out.println("band: " + solution.getValue("name"));
			}
			System.out.println();
	    }
	}
	
	static void execQueryGetBandsInLabelVariant(RepositoryConnection conn, String labelResource) 
	{	
	    String queryString = "PREFIX res: <http://music-is-the-answer.com/resource/> \n";
	    queryString += "PREFIX mu: <http://music-is-the-answer.com/ontology/> \n";
	    queryString += "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n";
	    queryString += "SELECT ?name \n";
	    queryString += "WHERE { \n";
	    queryString += "	?band rdf:type mu:Band . \n";
	    queryString += "    ?band mu:hasStageName ?name . \n";
	    queryString += "    ?band mu:signs ?contract . \n";
	    queryString +=      labelResource + " mu:offers ?contract . \n";
	    queryString += "} ORDER BY ?name";
	    TupleQuery query = conn.prepareTupleQuery(queryString); 

	    try (TupleQueryResult result = query.evaluate()) 
	    {
	    	System.out.println("Query 5 (variant) - The bands who signed a contract with the given label:");
			while (result.hasNext()) 
			{
			    BindingSet solution = result.next();
			    System.out.println("band: " + solution.getValue("name"));
			}
			System.out.println();
	    }
	}
	
	static void execQueryGetBandsInVenue(RepositoryConnection conn, String venue) 
	{	
	    String queryString = "PREFIX res: <http://music-is-the-answer.com/resource/> \n";
	    queryString += "PREFIX mu: <http://music-is-the-answer.com/ontology/> \n";
	    queryString += "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> \n";
	    queryString += "SELECT ?name \n";
	    queryString += "WHERE { \n";
	    queryString += "	?band rdf:type mu:Band . \n";
	    queryString += "    ?band mu:hasStageName ?name . \n";
	    queryString += "    ?band mu:performs_in ?concert . \n";
	    queryString += "    ?concert rdf:type mu:Concert . \n";
	    queryString += "    ?concert mu:takes_place_in_3 ?event . \n";
	    queryString += "    ?event mu:isLocatedAt ?venue . \n";
	    queryString += "    FILTER( ?venue = \"" + venue + "\" ) \n";
	    queryString += "} ORDER BY ?name";
	    TupleQuery query = conn.prepareTupleQuery(queryString); 

	    try (TupleQueryResult result = query.evaluate()) 
	    {
	    	System.out.println("Query 6 - The bands who played in the given venue:");
			while (result.hasNext()) 
			{
			    BindingSet solution = result.next();
			    System.out.println("band: " + solution.getValue("name"));
			}
	    }
	}
	
	
	public static void main(String[] args) 
	{
		//File dataDir = new File("C:\\temp\\myRepository\\");
		//Repository rep = new SailRepository(new MemoryStore(dataDir));
		Repository rep = new SailRepository(new MemoryStore());
	
		ValueFactory f = rep.getValueFactory();
		RepositoryConnection conn = rep.getConnection();
		
		try 
		{
			buildOntology(f);
			createIndividuals(f, conn);
			execQueryGetPerformers(conn);
			execQueryGetPlatforms(conn);
			execQueryGetLabels(conn);
			execQueryGetTracks(conn, "The Colour and the Shape", "Foo Fighters");
			execQueryGetTracksVariant(conn, "The Colour and the Shape", "res:band_1");
			execQueryGetBandsInLabel(conn, "Creation");
			execQueryGetBandsInLabelVariant(conn, "res:label_2");
			execQueryGetBandsInVenue(conn, "Roseland Ballroom");				
		} 
		finally 
		{
			conn.close();
		}
	}
}
