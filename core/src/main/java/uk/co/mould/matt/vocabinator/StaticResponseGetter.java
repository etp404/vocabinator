package uk.co.mould.matt.vocabinator;

public class StaticResponseGetter implements ResponseGetter {
    public void getJsonForWord(ResponseGetterCallback callback) {
        callback.success("{" +
                "  \"result\": \"ok\"," +
                "  \"tuc\": [" +
                "    {" +
                "      \"phrase\": {" +
                "        \"text\": \"so\"," +
                "        \"language\": \"en\"" +
                "      }," +
                "      \"meanings\": [" +
                "        {" +
                "          \"language\": \"en\"," +
                "          \"text\": \"in a particular manner\"" +
                "        }," +
                "        {" +
                "          \"language\": \"fr\"," +
                "          \"text\": \"De mani&egrave;re, de cette fa&ccedil;on\"" +
                "        }," +
                "        {" +
                "          \"language\": \"fr\"," +
                "          \"text\": \"ainsi(de cette facon)\"" +
                "        }," +
                "        {" +
                "          \"language\": \"en\"," +
                "          \"text\": \"In the way or manner described, indicated, or suggested\"" +
                "        }," +
                "        {" +
                "          \"language\": \"fr\"," +
                "          \"text\": \"Dans la fa&ccedil;on ou la mani&egrave;re d&eacute;crite, a indiqu&eacute;, ou sugg&eacute;r&eacute;\"" +
                "        }," +
                "        {" +
                "          \"language\": \"en\"," +
                "          \"text\": \"in a particular manner\"" +
                "        }" +
                "      ]," +
                "      \"meaningId\": 3195314028069101040," +
                "      \"authors\": [" +
                "        76" +
                "      ]" +
                "    }," +
                "    {" +
                "      \"phrase\": {" +
                "        \"text\": \"thus\"," +
                "        \"language\": \"en\"" +
                "      }," +
                "      \"meanings\": [" +
                "        {" +
                "          \"language\": \"en\"," +
                "          \"text\": \"as a result\"" +
                "        }," +
                "        {" +
                "          \"language\": \"en\"," +
                "          \"text\": \"in this way or manner\"" +
                "        }," +
                "        {" +
                "          \"language\": \"en\"," +
                "          \"text\": \"In the way or manner described, indicated, or suggested\"" +
                "        }," +
                "        {" +
                "          \"language\": \"fr\"," +
                "          \"text\": \"Dans la fa&ccedil;on ou la mani&egrave;re d&eacute;crite, a indiqu&eacute;, ou sugg&eacute;r&eacute;\"" +
                "        }," +
                "        {" +
                "          \"language\": \"en\"," +
                "          \"text\": \"in this way or manner\"" +
                "        }" +
                "      ]," +
                "      \"meaningId\": 3758747196619991161," +
                "      \"authors\": [" +
                "        6" +
                "      ]" +
                "    }," +
                "    {" +
                "      \"phrase\": {" +
                "        \"text\": \"such\"," +
                "        \"language\": \"en\"" +
                "      }," +
                "      \"meanings\": [" +
                "        {" +
                "          \"language\": \"fr\"," +
                "          \"text\": \"De mani&egrave;re, de cette fa&ccedil;on\"" +
                "        }" +
                "      ]," +
                "      \"meaningId\": -6734658019427217166," +
                "      \"authors\": [" +
                "        13" +
                "      ]" +
                "    }," +
                "    {" +
                "      \"phrase\": {" +
                "        \"text\": \"hence\"," +
                "        \"language\": \"en\"" +
                "      }," +
                "      \"meanings\": [" +
                "        {" +
                "          \"language\": \"en\"," +
                "          \"text\": \"as a result, therefore\"" +
                "        }," +
                "        {" +
                "          \"language\": \"en\"," +
                "          \"text\": \"as a result, therefore\"" +
                "        }" +
                "      ]," +
                "      \"meaningId\": -4551929113195686085," +
                "      \"authors\": [" +
                "        6" +
                "      ]" +
                "    }," +
                "    {" +
                "      \"phrase\": {" +
                "            \"text\": \"thereby\"," +
                "        \"language\": \"en\"" +
                "      }," +
                "      \"meanings\": [" +
                "        {" +
                "          \"language\": \"en\"," +
                "          \"text\": \"by that\"" +
                "        }" +
                "      ]," +
                "      \"meaningId\": -7663788489866407717," +
                "      \"authors\": [" +
                "        70195" +
                "      ]" +
                "    }," +
                "    {" +
                "      \"phrase\": {" +
                "        \"text\": \"in this way\"," +
                "        \"language\": \"en\"" +
                "      }," +
                "      \"meanings\": [" +
                "        {" +
                "          \"language\": \"fr\"," +
                "          \"text\": \"ainsi(de cette facon)\"" +
                "        }" +
                "      ]," +
                "      \"meaningId\": 1888001379950043280," +
                "      \"authors\": [" +
                "        76" +
                "      ]" +
                "    }" +
                "  ]," +
                "  \"phrase\": \"ainsi\"," +
                "  \"from\": \"fr\"," +
                "  \"dest\": \"en\"," +
                "  \"authors\": {" +
                "    \"1\": {" +
                "      \"U\": \"http://en.wiktionary.org\"," +
                "      \"id\": 1," +
                "      \"N\": \"en.wiktionary.org\"," +
                "      \"url\": \"https://glosbe.com/source/1\"" +
                "    }," +
                "    \"6\": {" +
                "      \"U\": \"http://de.wiktionary.org\"," +
                "      \"id\": 6," +
                "      \"N\": \"de.wiktionary.org\"," +
                "      \"url\": \"https://glosbe.com/source/6\"" +
                "    }," +
                "    \"13\": {" +
                "      \"U\": \"http://ro.wiktionary.org\"," +
                "      \"id\": 13," +
                "      \"N\": \"ro.wiktionary.org\"," +
                "      \"url\": \"https://glosbe.com/source/13\"" +
                "    }," +
                "    \"36\": {" +
                "      \"U\": \"http://freedict.org\"," +
                "      \"id\": 36," +
                "      \"N\": \"freedict.org\"," +
                "      \"url\": \"https://glosbe.com/source/36\"" +
                "    }," +
                "    \"76\": {" +
                "      \"U\": \"http://www.csse.monash.edu.au/~jwb/jmdict.html\"," +
                "      \"id\": 76," +
                "      \"N\": \"JMdict\"," +
                "      \"url\": \"https://glosbe.com/source/76\"" +
                "    }," +
                "    \"2697\": {" +
                "      \"U\": \"http://dumps.wikimedia.org/dewiktionary/latest/dewiktionary-latest-pages-articles.xml.bz2\"," +
                "      \"id\": 2697," +
                "      \"N\": \"Wikiworterbuch\"," +
                "      \"url\": \"https://glosbe.com/source/2697\"" +
                "    }," +
                "    \"2907\": {" +
                "      \"U\": \"http://download.tuxfamily.org/polyglotte/dicos/dict/anglais/\"," +
                "      \"id\": 2907," +
                "      \"N\": \"French-English\"," +
                "      \"url\": \"https://glosbe.com/source/2907\"" +
                "    }," +
                "    \"25018\": {" +
                "      \"U\": \"http://glosbe.com\"," +
                "      \"id\": 25018," +
                "      \"N\": \"Administratorus\"," +
                "      \"url\": \"https://glosbe.com/source/25018\"" +
                "    }," +
                "    \"25115\": {" +
                "      \"U\": \"\"," +
                "      \"id\": 25115," +
                "      \"N\": \"Administratorus\"," +
                "      \"url\": \"https://glosbe.com/source/25115\"" +
                "    }," +
                "    \"69425\": {" +
                "      \"U\": \"\"," +
                "      \"id\": 69425," +
                "      \"N\": \"plwiktionary.org\"," +
                "      \"url\": \"https://glosbe.com/source/69425\"" +
                "    }," +
                "    \"70195\": {" +
                "      \"U\": \"\"," +
                "      \"id\": 70195," +
                "      \"N\": \"Administratorus\"," +
                "      \"url\": \"https://glosbe.com/source/70195\"" +
                "    }" +
                "  }" +
                "}");
    }
}
