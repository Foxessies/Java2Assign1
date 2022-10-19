import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.join;

public class MovieAnalyzer {
    private Stream<Movie> AllMovie;private List<Movie> Movielist;
    public static class Movie  {
        private int Released_Year;
        private String Poster_Link;
        private	String Series_Title;
        private String Certificate;
        private String Runtime;
        private String Genre;
        private float IMDB_Rating;
        private String Overview;
        private int Meta_score;
        private String Director;

        private String Star1;private String	Star2;private String Star3;private String Star4;
        private int No_of_Votes;
        private int Gross;

        public Movie(int Year,String Link,String Title, String certificate,
                                  String runtime, String genre, float  Rating, String overview	, int  score,
                                  String director, String star1,String	star2,String star3,String star4, int  Votes,
                                  int gross){
            this.Released_Year=Year;
            this.Poster_Link=Link;
            this.Director=director;
            this.Series_Title=Title;
            this.Certificate=certificate;
            this.Runtime=runtime;
            this.Genre=genre;
            this.IMDB_Rating=Rating;
            this.Overview=overview;
            this.Meta_score=score;
            this.Star1=star1;this.Star2=star2;this.Star3=star3;this.Star4=star4;
            this.No_of_Votes=Votes;this.Gross=gross;
        }
        public Movie(String Title,
                     String runtime, String overview	){
            this.Series_Title=Title;
            this.Runtime=runtime;
            this.Overview=overview;
        }

        public Movie(){

        }

        public int getReleased_Year() {
            return Released_Year;
        }

        public void setReleased_Year(int released_Year) {
            Released_Year = released_Year;
        }

        public String getPoster_Link() {
            return Poster_Link;
        }

        public void setPoster_Link(String poster_Link) {
            Poster_Link = poster_Link;
        }

        public String getSeries_Title() {
            return Series_Title;
        }

        public void setSeries_Title(String series_Title) {
            Series_Title = series_Title;
        }

        public String getCertificate() {
            return Certificate;
        }

        public void setCertificate(String certificate) {
            Certificate = certificate;
        }

        public String getRuntime() {
            return Runtime;
        }

        public void setRuntime(String runtime) {
            Runtime = runtime;
        }

        public String getGenre() {
            return Genre;
        }

        public void setGenre(String genre) {
            Genre = genre;
        }

        public double getIMDB_Rating() {
            return IMDB_Rating;
        }

        public void setIMDB_Rating(float IMDB_Rating) {
            this.IMDB_Rating = IMDB_Rating;
        }

        public String getOverview() {
            return Overview;
        }

        public void setOverview(String overview) {
            Overview = overview;
        }

        public int getMeta_score() {
            return Meta_score;
        }

        public void setMeta_score(int meta_score) {
            Meta_score = meta_score;
        }

        public String getDirector() {
            return Director;
        }

        public void setDirector(String director) {
            Director = director;
        }

        public String getStar1() {
            return Star1;
        }

        public void setStar1(String star1) {
            Star1 = star1;
        }

        public String getStar2() {
            return Star2;
        }

        public void setStar2(String star2) {
            Star2 = star2;
        }

        public String getStar3() {
            return Star3;
        }

        public void setStar3(String star3) {
            Star3 = star3;
        }

        public String getStar4() {
            return Star4;
        }

        public void setStar4(String star4) {
            Star4 = star4;
        }

        public int getNo_of_Votes() {
            return No_of_Votes;
        }

        public void setNo_of_Votes(int no_of_Votes) {
            No_of_Votes = no_of_Votes;
        }

        public int getGross() {
            return Gross;
        }

        public void setGross(int gross) {
            Gross = gross;
        }
    }
     public static String trimBothEnds(String srcStr, String splitter) {
        String regex = "^" + splitter + "*|" + splitter + "*$";
        System.out.println(regex);
        return srcStr.replaceAll(regex, "");
    }
    public MovieAnalyzer(String dataset_path) {
//        List<Movie> Movielist = null;
        int i=0;int j=0;
        try  {
            //(BufferedReader br = Files.newBufferedReader(Paths.get(dataset_path)))
            InputStreamReader isr = new InputStreamReader(new FileInputStream(dataset_path), "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String line;
            Movielist = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)",-1);
                i++;
//                String mid=String.join("|", columns);
//                System.out.println(String.join("|", columns));
//                String[] New=mid.split("\\|");

                Movie x = new Movie();
 //               if (columns.length == 16) {
//                    System.out.println(New[15]);
                    x.setPoster_Link(columns[0]);
                    x.setSeries_Title(columns[1]);
                    if (columns[2] != null && columns[2].matches("-?\\d+(\\.\\d+)?")) {
                        x.setReleased_Year(Integer.parseInt(columns[2]));
//                        j++;
//                        System.out.println(j);
                    }
                    x.setCertificate(columns[3]);
                    x.setRuntime(columns[4]);
                    x.setGenre(columns[5]);
                    if (columns[6] != null && columns[6].matches("-?\\d+(\\.\\d+)?")) {
                        x.setIMDB_Rating((float) Double.parseDouble(columns[6]));
                    }
                    x.setOverview(columns[7].replaceAll("^\"*|\"*$",""));
                    if (columns[8] != null && columns[8].matches("-?\\d+(\\.\\d+)?")) {
                        x.setMeta_score(Integer.parseInt(columns[8]));
                    }
                    x.setDirector(columns[9]);
                    x.setStar1(columns[10]);
                    x.setStar2(columns[11]);
                    x.setStar3(columns[12]);
                    x.setStar4(columns[13]);
                    if (columns[14] != null && columns[14].matches("-?\\d+(\\.\\d+)?")) {
                        x.setNo_of_Votes(Integer.parseInt(columns[14]));
                    } else {
                        continue;
                    }
                    if(!Objects.equals(columns[15], "")){
                        int p=Integer.parseInt(columns[15].replace(",","").replaceAll("^\"*|\"*$",""));
                        if (columns[15].replace(",", "").replaceAll("^\"*|\"*$","").matches("-?\\d+(\\.\\d+)?")) {
                            x.setGross(p);
                        }
                    }
                    Movielist.add(x);


//                }
//                System.out.println(columns[15]);
//                System.out.println(x.getGross());

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        AllMovie=Movielist.stream();
//        System.out.println(AllMovie);
//        System.out.println(Movielist.size());
//        System.out.println(i);
    }


    public static LinkedHashMap<String, Double> sortMap(Map<String, Double> map) {
        return map.entrySet().stream().sorted(((item1, item2) -> {
            int compare = item2.getValue().compareTo(item1.getValue());
            if (compare == 0) {
                if (item1.getKey().compareTo(item2.getKey())<=0) {
                    compare = -1;
                } else if (item1.getKey().compareTo(item2.getKey())>0) {
                    compare = 1;
                }
            }
            return compare;
        })).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }


    public Map<Integer, Integer> getMovieCountByYear(){
        Stream<Movie> All=Movielist.stream();
        Map<Integer, Integer> list1=new TreeMap<>();Map<Integer, Integer> map1=new LinkedHashMap<>();
        Map<Integer,Long> yearCount=All.collect(Collectors.groupingBy(Movie::getReleased_Year, Collectors.counting()));
        List<Integer> li=new ArrayList<>();
        for(Integer m:yearCount.keySet()){
            list1.put(m,Integer.parseInt(yearCount.get(m).toString()));
            li.add(m);
        }
       Collections.reverse(li);
        for(int i:li){
            map1.put(i,list1.get(i));
        }
 //       System.out.println(map1);
        return map1;
    }

    public Map<String, Integer> getMovieCountByGenre(){
        int d = 0,c= 0,ac= 0,ad= 0,b= 0,hi= 0,t= 0,m= 0,an= 0,f= 0,ho= 0,w= 0,fa= 0,sf=0,co=0,we=0,sp=0,fn=0,r=0,my=0,ml=0;
        int[] xy={d,c,ac,ad,b,hi,t,m,an,f,ho,w,fa,sf,co,we,sp,fn,r,my,ml};int mid=0;
        Map<String, Integer> map2 = new TreeMap<String, Integer>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        return obj1.compareTo(obj2);
                    }
                });
        Map<String, Integer> list2=new HashMap<>();
        Map.Entry<String, Integer> entry = null;
//        Map<String,Integer> map2=new LinkedHashMap<String,Integer>();
//        Map<String,Long> yearCount=AllMovie.collect(Collectors.groupingBy(Movie::getGenre, Collectors.counting()));
        Stream<Movie> All=Movielist.stream();
        List<String> listGenre= All.map(Movie::getGenre).toList();
        for(String s:listGenre){
            if(s.contains("Drama")){d++;}if(s.contains("Sci-Fi")){sf++;}
            if(s.contains("Crime")){c++;}if(s.contains("Animation")){an++;}
            if(s.contains("Action")){ac++;}if(s.contains("War")){w++;}
            if(s.contains("Adventure")){ad++;}if(s.contains("Comedy")){co++;}
            if(s.contains("Family")){f++;}if(s.contains("Western")){we++;}
            if(s.contains("Fantasy")){fa++;}if(s.contains("Horror")){ho++;}
            if(s.contains("Thriller")){t++;}if(s.contains("History")){hi++;}
            if(s.contains("Music")){m++;}if(s.contains("Sport")){sp++;}
            if(s.contains("Biography")){b++;}if(s.contains("Film-Noir")){fn++;}
            if(s.contains("Romance")){r++;}if(s.contains("Mystery")){my++;}if(s.contains("Musical")){ml++;}
        }
        m=m-ml;

        list2.put("Drama",d);list2.put("Crime",c);list2.put("Action",ac);list2.put("Adventure",ad);list2.put("Family",f);
        list2.put("Fantasy",fa);list2.put("Thriller",t);list2.put("Music",m);list2.put("Biography",b);list2.put("Romance",r);
        list2.put("Sci-Fi",sf);list2.put("Animation",an);list2.put("War",w);list2.put("Comedy",co);list2.put("Western",we);
        list2.put("Horror",ho);list2.put("History",hi);list2.put("Sport",sp);list2.put("Film-Noir",fn);list2.put("Mystery",my);list2.put("Musical",ml);
//        System.out.println(list2);
        list2.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEachOrdered(e -> map2.put(e.getKey(), e.getValue()));
        return map2.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare( map2.get(e2.getKey()),map2.get(e1.getKey())))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }

    public Map<List<String>, Integer> getCoStarCount(){
        Map<List<String>, Integer> map3=new HashMap<>();
        for(int b=0;b<Movielist.size();b++){
            List<List<String>> l=new LinkedList<>() {};

            List<String> sb= new ArrayList<>();sb.add(Movielist.get(b).getStar1());sb.add(Movielist.get(b).getStar2());
            l.add(sb.stream().sorted().collect(Collectors.toList()));
            List<String> sa= new ArrayList<>();sa.add(Movielist.get(b).getStar1());sa.add(Movielist.get(b).getStar3());
            l.add(sa.stream().sorted().collect(Collectors.toList()));
            List<String> sd= new ArrayList<>();sd.add(Movielist.get(b).getStar1());sd.add(Movielist.get(b).getStar4());
            l.add(sd.stream().sorted().collect(Collectors.toList()));
            List<String> sf= new ArrayList<>();sf.add(Movielist.get(b).getStar2());sf.add(Movielist.get(b).getStar3());
            l.add(sf.stream().sorted().collect(Collectors.toList()));
            List<String> sg= new ArrayList<>();sg.add(Movielist.get(b).getStar2());sg.add(Movielist.get(b).getStar4());
            l.add(sg.stream().sorted().collect(Collectors.toList()));
            List<String> sq= new ArrayList<>();sq.add(Movielist.get(b).getStar3());sq.add(Movielist.get(b).getStar4());
            l.add(sq.stream().sorted().collect(Collectors.toList()));

            outer:for(int i=0;i<6;i++){
                Set<List<String>> set=map3.keySet();
                for(List<String> sset:set){
                    if(sset.equals(l.get(i))){
                        break outer;
                    }
                }

                int x=1;
                for(int a=1+b;a<Movielist.size();a++){
                    List<List<String>> ll=new LinkedList<>();
                    List<String> n= new ArrayList<>();n.add(Movielist.get(a).getStar1());n.add(Movielist.get(a).getStar2());
                    ll.add(n.stream().sorted().collect(Collectors.toList()));
                    List<String> nn= new ArrayList<>();nn.add(Movielist.get(a).getStar1());nn.add(Movielist.get(a).getStar3());
                    ll.add(nn.stream().sorted().collect(Collectors.toList()));
                    List<String> nv= new ArrayList<>();nv.add(Movielist.get(a).getStar1());nv.add(Movielist.get(a).getStar4());
                    ll.add(nv.stream().sorted().collect(Collectors.toList()));
                    List<String> nz= new ArrayList<>();nz.add(Movielist.get(a).getStar2());nz.add(Movielist.get(a).getStar3());
                    ll.add(nz.stream().sorted().collect(Collectors.toList()));
                    List<String> nx= new ArrayList<>();nx.add(Movielist.get(a).getStar2());nx.add(Movielist.get(a).getStar4());
                    ll.add(nx.stream().sorted().collect(Collectors.toList()));
                    List<String> nc= new ArrayList<>();nc.add(Movielist.get(a).getStar3());nc.add(Movielist.get(a).getStar4());
                    ll.add(nc.stream().sorted().collect(Collectors.toList()));

                    for(int k=0;k<6;k++){
                        if (l.get(i).equals(ll.get(k))) {
                            x++;
                        }
                    }
                }     map3.put(l.get(i),x);
            }
        }
        Map<List<String>, Integer> m1 = new LinkedHashMap<>();
        map3.entrySet().stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue())).toList().forEach(e -> m1.put(e.getKey(), e.getValue()));

        System.out.println(m1);
        return m1;
    }

    public List<String> getTopMovies(int top_k, String by){
        List<String> map4=new ArrayList<>();
        List<String> map44=new ArrayList<>();
        List<Movie> list4 = new ArrayList<>();List<Movie> list44 = new ArrayList<>();
        Movielist.forEach(p -> {
            list4.add(new Movie(p.getSeries_Title(),p.getRuntime(),p.getOverview()));
        });

        if(by.equals("runtime")){
            for(Movie m:list4){
                list44.add(new Movie(m.getSeries_Title().replaceAll("^\"*|\"*$",""),m.getRuntime(),m.getOverview()));
            }
            list44.sort(Comparator.comparing(Movie::getSeries_Title));
            list44.sort((o1, o2) -> Integer.parseInt(o2.getRuntime().substring(0,o2.getRuntime().length()-4))-Integer.parseInt(o1.getRuntime().substring(0,o1.getRuntime().length()-4)));
            for(Movie movies:list44){
                map44.add(movies.getSeries_Title());
            }
        }

        if(by.equals("overview")){
            for(Movie m:list4){
                list44.add(new Movie(m.getSeries_Title().replaceAll("^\"*|\"*$",""),m.getRuntime(),m.getOverview()));
            }
            list44.sort(Comparator.comparing(Movie::getSeries_Title));
            list44.sort((o1, o2) -> (o2.getOverview().length()-o1.getOverview().length()));
            for(Movie movies:list44){
                map44.add(movies.getSeries_Title());
            }
 //           System.out.println(map4.subList(0,top_k));
 //           System.out.println(map44.subList(0,top_k));
        }
        return map44.subList(0,top_k);
    }

    public List<String> getTopStars(int top_k, String by){
        List<String> list5=new ArrayList<>();
        Map<String,Double> map5=new HashMap<>();
        if(by.equals("rating")){
            Set<String> set=new HashSet<String>();
            for(Movie m:Movielist){
                set.add(m.getStar1());set.add(m.getStar3());
                set.add(m.getStar2());set.add(m.getStar4());
            }
            for(String s:set){
                double ff=0; int n=0; double avg=0;
                for(int i=0;i< Movielist.size();i++){
                    if(s.equals(Movielist.get(i).getStar1())){
                        ff+=Movielist.get(i).getIMDB_Rating();
                        n++;
                    }
                    if(s.equals(Movielist.get(i).getStar2())){
                        ff+=Movielist.get(i).getIMDB_Rating();
                        n++;
                    }
                    if(s.equals(Movielist.get(i).getStar3())){
                        ff+=Movielist.get(i).getIMDB_Rating();
                        n++;
                    }
                    if(s.equals(Movielist.get(i).getStar4())){
                        ff+=Movielist.get(i).getIMDB_Rating();
                        n++;
                    }
                }
                BigDecimal ffBig = new BigDecimal(ff);
                BigDecimal nBig = new BigDecimal(n);
                BigDecimal avgBig = ffBig.divide(nBig,BigDecimal.ROUND_HALF_DOWN,BigDecimal.ROUND_DOWN);
                avg = avgBig.doubleValue();
                map5.put(s, avg);
            }
            LinkedHashMap<String, Double> m5 = sortMap(map5);

//            System.out.println(m5);
            list5=new ArrayList<String>(m5.keySet());
//            System.out.println(list5.subList(0,top_k));
        }

        if(by.equals("gross")){
            Set<String> set=new HashSet<String>();
            for(Movie m:Movielist){
                set.add(m.getStar1());set.add(m.getStar3());
                set.add(m.getStar2());set.add(m.getStar4());
            }
            for(String s:set){
                long gg=0; int n=0; double avg=0;
                for(int i=0;i< Movielist.size();i++){
                    if(s.equals(Movielist.get(i).getStar1())&&Movielist.get(i).getGross()!=0){
                        gg+=Movielist.get(i).getGross();
 //                       System.out.println(Movielist.get(i).getGross());
                        n++;
                    }
                    if(s.equals(Movielist.get(i).getStar2())&&Movielist.get(i).getGross()!=0){
                        gg+=Movielist.get(i).getGross();
                        n++;
                    }
                    if(s.equals(Movielist.get(i).getStar3())&&Movielist.get(i).getGross()!=0){
                        gg+=Movielist.get(i).getGross();
                        n++;
                    }
                    if(s.equals(Movielist.get(i).getStar4())&&Movielist.get(i).getGross()!=0){

                        gg+=Movielist.get(i).getGross();
                        n++;
                    }
                }
                if (n != 0) {
                    BigDecimal ffBig = new BigDecimal(gg);
                    BigDecimal nBig = new BigDecimal(n);
                    BigDecimal avgBig = ffBig.divide(nBig,BigDecimal.ROUND_HALF_DOWN);
                    avg = avgBig.doubleValue();
                    map5.put(s, avg);
                }
            }
            LinkedHashMap<String, Double> m55 = sortMap(map5);
//            System.out.println(m55);
            list5=new ArrayList<String>(m55.keySet());
 //           System.out.println(list5.subList(0,top_k));
        }

        return list5.subList(0,top_k);
    }

    public List<String> searchMovies(String genre, float min_rating, int max_runtime){
        List<String> map6=new ArrayList<>(); Stream<Movie> Al=Movielist.stream();
        List<Movie> list6= Al.filter(s->s.getGenre().contains(genre) && (float)s.getIMDB_Rating() >=min_rating&&Integer.parseInt(s.getRuntime().substring(0,s.getRuntime().length()-4))<=max_runtime).collect(Collectors.toList());
        for(Movie m:list6){
            map6.add(m.Series_Title);
        }
        List<String> map66=new ArrayList<>();
        for(String s:map6){
            map66.add(s.replaceAll("^\"*|\"*$",""));
        }
        Collections.sort(map66);
//        System.out.println(map66);
        return map66;
    }


    public static void main(String[] args) {
       MovieAnalyzer M=new MovieAnalyzer("C:/Users/Evan玖/Desktop/java/A1_Sample/src/imdb_top_500 - 2.csv");
 //       MovieAnalyzer M=new MovieAnalyzer("C:/Users/Evan玖/Desktop/java/A1_Sample/src/imdb_top_500.csv");
       M.getCoStarCount();
 //       System.out.println(M.getMovieCountByYear());
 //       System.out.println(M.getMovieCountByGenre());
 //      M.getTopMovies(20,"overview");
//       M.getTopStars(15,"gross");
//        M.searchMovies("Sci-Fi", 8.2f, 200);


    }
    }