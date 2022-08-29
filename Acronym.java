import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Acronym {
    private String phrase;
    Acronym(String phrase) {
        this.phrase = phrase;
    }
    public String getPhrase() {
		return phrase;
	}
	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	String get() {
		
		StringBuilder builder = new StringBuilder();
		List<String> acronymBySpace = Arrays.stream(getPhrase()
				 							.split(" "))
				 						    .collect(Collectors
                                                 .toList());
		
		 List<String> acronymByHyphen = acronymBySpace
                                                .stream()
				 								.map(e->Arrays
                                                .asList(e.split("-")))
				 								.flatMap(List::stream)
				 						        .collect(Collectors
                                                .toList());
		 
		 List<String> acronymByUnderscore = acronymByHyphen
                                                 .stream()
												 .map(e->Arrays
                                                 .asList(e.split("_")))
												 .flatMap(List::stream)
										         .collect(Collectors
                                                 .toList());
		
		List<Character> acronym = acronymByUnderscore
                                            .stream()
											.filter(e->e.length()>0) 
											.map(e->Character
                                            .toUpperCase(e.charAt(0)))
										    .collect(Collectors
                                            .toList());
		acronym.forEach(ch->builder.append(ch));
		return builder.toString();
	}

}
