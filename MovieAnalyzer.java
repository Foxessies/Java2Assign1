import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** MovieAnalyzer for Java A1. */
public class MovieAnalyzer {
  private Stream<Movie> allmovies;
  private List<Movie> moviesList;

  /** Movie class. */
  public static class Movie  {
    private int releasedYear;
    private String posterLink;
    private	String seriesTitle;
    private String certificate;
    private String runtime;
    private String ggenre;
    private float imdbRating;
    private String overview;
    private int metascore;
    private String director;
    private String star1;
    private String star2;
    private String star3;
    private String star4;
    private int noVotes;
    private int ggross;

    /** public Movie. */
    public Movie(int year, String link, String title, String certificate, String runtime,
                 String genre, float  rating, String overview, int  score, String director,
                 String star1, String star2, String star3, String star4, int  votes, int ggross) {
      this.releasedYear = year;
      this.posterLink = link;
      this.director = director;
      this.seriesTitle = title;
      this.certificate = certificate;
      this.runtime = runtime;
      this.ggenre = genre;
      this.imdbRating = rating;
      this.overview = overview;
      this.metascore = score;
      this.star1 = star1;
      this.star2 = star2;
      this.star3 = star3;
      this.star4 = star4;
      this.noVotes = votes;
      this.ggross = ggross;
    }

    public Movie(String title,
                     String runtime, String overview) {
      this.seriesTitle = title;
      this.runtime = runtime;
      this.overview = overview;
    }

    public Movie() {

    }

    public int getReleasedYear() {
      return releasedYear;
    }

    public void setReleasedYear(int releasedYear) {
      this.releasedYear = releasedYear;
    }

    public String getPosterLink() {
      return posterLink;
    }

    public void setPosterLink(String posterLink) {
      this.posterLink = posterLink;
    }

    public String getSeriesTitle() {
      return seriesTitle;
    }

    public void setSeriesTitle(String seriesTitle) {
      this.seriesTitle = seriesTitle;
    }

    public String getCertificate() {
      return certificate;
    }

    public void setCertificate(String certificate) {
      this.certificate = certificate;
    }

    public String getRuntime() {
      return runtime;
    }

    public void setRuntime(String runtime) {
      this.runtime = runtime;
    }

    public String getGgenre() {
      return ggenre;
    }

    public void setGgenre(String ggenre) {
      this.ggenre = ggenre;
    }

    public double getImdbRating() {
      return imdbRating;
    }

    public void setImdbRating(float imdbRating) {
      this.imdbRating = imdbRating;
    }

    public String getOverview() {
      return overview;
    }

    public void setOverview(String overview) {
      this.overview = overview;
    }

    public int getMetascore() {
      return metascore;
    }

    public void setMetascore(int metascore) {
      this.metascore = metascore;
    }

    public String getDirector() {
      return director;
    }

    public void setDirector(String director) {
      this.director = director;
    }

    public String getStar1() {
      return star1;
    }

    public void setStar1(String star1) {
      this.star1 = star1;
    }

    public String getStar2() {
      return star2;
    }

    public void setStar2(String star2) {
      this.star2 = star2;
    }

    public String getStar3() {
      return star3;
    }

    public void setStar3(String star3) {
      this.star3 = star3;
    }

    public String getStar4() {
      return star4;
    }

    public void setStar4(String star4) {
      this.star4 = star4;
    }

    public int getNoVotes() {
      return noVotes;
    }

    public void setNoVotes(int noVotes) {
      this.noVotes = noVotes;
    }

    public int getGgross() {
      return ggross;
    }

    public void setGgross(int ggross) {
      this.ggross = ggross;
    }
  }

  public static String trimBothEnds(String srcStr, String splitter) {
    String regex = "^" + splitter + "*|" + splitter + "*$";
    System.out.println(regex);
    return srcStr.replaceAll(regex, "");
  }

  public MovieAnalyzer(String datasetPath) {
    int i = 0;
    int j = 0;
    try  {
      InputStreamReader isr = new InputStreamReader(
              new FileInputStream(datasetPath), "UTF-8");
      BufferedReader br = new BufferedReader(isr);
      String line;
      moviesList = new ArrayList<>();
      while ((line = br.readLine()) != null) {
        String[] columns = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
        i++;
        Movie x = new Movie();
        x.setPosterLink(columns[0]);
        x.setSeriesTitle(columns[1]);
        if (columns[2] != null && columns[2].matches("-?\\d+(\\.\\d+)?")) {
          x.setReleasedYear(Integer.parseInt(columns[2]));
        }
        x.setCertificate(columns[3]);
        x.setRuntime(columns[4]);
        x.setGgenre(columns[5]);
        if (columns[6] != null && columns[6].matches("-?\\d+(\\.\\d+)?")) {
          x.setImdbRating((float) Double.parseDouble(columns[6]));
        }
        x.setOverview(columns[7].replaceAll("^\"*|\"*$", ""));
        if (columns[8] != null && columns[8].matches("-?\\d+(\\.\\d+)?")) {
          x.setMetascore(Integer.parseInt(columns[8]));
        }
        x.setDirector(columns[9]);
        x.setStar1(columns[10]);
        x.setStar2(columns[11]);
        x.setStar3(columns[12]);
        x.setStar4(columns[13]);
        if (columns[14] != null && columns[14].matches("-?\\d+(\\.\\d+)?")) {
          x.setNoVotes(Integer.parseInt(columns[14]));
        } else {
          continue;
        }
        if (! Objects.equals(columns[15], "")) {
          int p = Integer.parseInt(columns[15].replace(",", "").replaceAll("^\"*|\"*$", ""));
          if (columns[15].replace(",",  "")
                  .replaceAll("^\"*|\"*$", "").matches("-?\\d+(\\.\\d+)?")) {
            x.setGgross(p);
          }
        }
        moviesList.add(x);
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    allmovies = moviesList.stream();
  }

  /** sortMap method1. */
  public static LinkedHashMap<String, Double> sortMap(Map<String, Double> map) {
    return map.entrySet().stream().sorted(((item1, item2) -> {
      int compare = item2.getValue().compareTo(item1.getValue());
      if (compare == 0) {
        if (item1.getKey().compareTo(item2.getKey()) <= 0) {
          compare = -1;
        } else if (item1.getKey().compareTo(item2.getKey()) > 0) {
          compare = 1;
        }
      }
      return compare;
    })).collect(Collectors.toMap(Map.Entry::getKey,
            Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
  }

  /** getMovieCountByYear method. */
  public Map<Integer, Integer> getMovieCountByYear() {
    Stream<Movie> aall = moviesList.stream();
    Map<Integer, Integer> list1 = new TreeMap<>();
    Map<Integer, Integer> map1 = new LinkedHashMap<>();
    Map<Integer, Long> yearCount = aall.collect(Collectors
            .groupingBy(Movie::getReleasedYear, Collectors.counting()));
    List<Integer> li = new ArrayList<>();
    for (Integer m : yearCount.keySet()) {
      list1.put(m, Integer.parseInt(yearCount.get(m).toString()));
      li.add(m);
    }
    Collections.reverse(li);
    for (int i : li) {
      map1.put(i, list1.get(i));
    }
    return map1;
  }

  /** sortMap method2. */
  public static <K, V extends Comparable<? super V>> Map<K, V> sortDescend(Map<K, V> map) {
    List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
        @Override
        public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
            int compare = (o1.getValue()).compareTo(o2.getValue());
            return -compare;
        }
    });

    Map<K, V> returnMap = new LinkedHashMap<K, V>();
    for (Map.Entry<K, V> entry : list) {
      returnMap.put(entry.getKey(), entry.getValue());
    }
    return returnMap;
  }

  /** getMovieCountByGenre method. */
  public Map<String, Integer> getMovieCountByGenre() {
    Stream<Movie> aall = moviesList.stream();
    List<String> lei = new LinkedList<>();
    for (Movie m : moviesList) {
      String[] s = m.getGgenre().replaceAll("^\"*|\"*$", "")
              .replaceAll(" ", "").split(",");
      Collections.addAll(lei, s);
    }
    Map<String, Long> map22 = lei.stream()
            .collect(Collectors.groupingBy(k -> k, Collectors.counting()));
    Map<String, Integer> map2 = new TreeMap<>();
    Map<String, Integer> map222 = new TreeMap<>();
    map22.entrySet().forEach(e -> map2.put(e.getKey(), Integer.parseInt(e.getValue().toString())));
    map222 = sortDescend(map2);
    return map222;
  }

  /** sortMap method3. */
  public static LinkedHashMap<List<String>, Integer> sortArrMap(Map<List<String>, Long> map) {
    return map.entrySet().stream().sorted(((item1, item2) -> {
      int compare = item2.getValue().compareTo(item1.getValue());
      if (compare == 0) {
        if (String.join(",", item1.getKey()).compareTo(String.join(",", item2.getKey())) <= 0) {
          compare = -1;
        } else if (String.join(",", item1.getKey())
                .compareTo(String.join(",", item2.getKey())) > 0) {
          compare = 1;
        }
      }
      return compare;
    })).collect(Collectors.toMap(map1 -> map1.getKey(), map1 -> map1.getValue().intValue(),
            (e1, e2) -> e1, LinkedHashMap::new));
  }

  /** get the combination of stars method. */
  public static List<List<String>> combination(List<String> starList) {
    List<List<String>> combinationList = new ArrayList<>();
    for (int i = 0; i < starList.size(); i++) {
      for (int j = i + 1; j < starList.size(); j++) {
        List<String> starStr = new ArrayList<>();
        starStr.add(starList.get(i));
        starStr.add(starList.get(j));
        if (!combinationList.contains(starStr)) {
          List<String> sort = starStr.stream().sorted().collect(Collectors.toList());
          combinationList.add(sort);
        }
      }
    }
    return combinationList;
  }

  /** getCoStarCount method. */
  public Map<List<String>, Integer> getCoStarCount() {
    List<List<List<String>>> allSta = new ArrayList<>();
    List<List<String>> l = new LinkedList<>() {};
    for (int b = 0; b < moviesList.size(); b++) {
      List<String> sb = new ArrayList<>();
      sb.add(moviesList.get(b).getStar1());
      sb.add(moviesList.get(b).getStar2());
      List<String> sbb = sb.stream().sorted().toList();
      l.add(sbb);
      List<String> sa = new ArrayList<>();
      sa.add(moviesList.get(b).getStar1());
      sa.add(moviesList.get(b).getStar3());
      List<String> saa = sa.stream().sorted().toList();
      l.add(saa);
      List<String> sd = new ArrayList<>();
      sd.add(moviesList.get(b).getStar1());
      sd.add(moviesList.get(b).getStar4());
      List<String> sdd = sd.stream().sorted().toList();
      l.add(sdd);
      List<String> sf = new ArrayList<>();
      sf.add(moviesList.get(b).getStar2());
      sf.add(moviesList.get(b).getStar3());
      List<String> sff = sf.stream().sorted().toList();
      l.add(sff);
      List<String> sg = new ArrayList<>();
      sg.add(moviesList.get(b).getStar2());
      sg.add(moviesList.get(b).getStar4());
      List<String> sgg = sg.stream().sorted().toList();
      l.add(sgg);
      List<String> sq = new ArrayList<>();
      sq.add(moviesList.get(b).getStar3());
      sq.add(moviesList.get(b).getStar4());
      List<String> sqq = sq.stream().sorted().toList();
      l.add(sqq);
    }

    Map<List<String>, Long> resMap = l.stream()
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    Map<List<String>, Integer> stringLongMap = sortArrMap(resMap);
    return stringLongMap;
  }

  /** getTopMovie method. */
  public List<String> getTopMovies(int topmomvie, String by) {
    List<String> map4 = new ArrayList<>();
    List<String> map44 = new ArrayList<>();
    List<Movie> list4 = new ArrayList<>();
    List<Movie> list44 = new ArrayList<>();
    moviesList.forEach(p -> {
      list4.add(new Movie(p.getSeriesTitle(), p.getRuntime(), p.getOverview()));
    });
    if (by.equals("runtime")) {
      for (Movie m : list4) {
        list44.add(new Movie(m.getSeriesTitle()
                .replaceAll("^\"*|\"*$", ""), m.getRuntime(), m.getOverview()));
      }
      list44.sort(Comparator.comparing(Movie::getSeriesTitle));
      list44.sort((o1, o2) -> Integer.parseInt(o2.getRuntime().substring(0, o2.getRuntime()
                .length() - 4)) - Integer.parseInt(o1.getRuntime()
              .substring(0, o1.getRuntime().length() - 4)));
      for (Movie movies : list44) {
        map44.add(movies.getSeriesTitle());
      }
    }
    if (by.equals("overview")) {
      for (Movie m : list4) {
        list44.add(new Movie(m.getSeriesTitle().replaceAll("^\"*|\"*$", ""),
                m.getRuntime(), m.getOverview()));
      }
      list44.sort(Comparator.comparing(Movie::getSeriesTitle));
      list44.sort((o1, o2) -> (o2.getOverview().length() - o1.getOverview().length()));
      for (Movie movies : list44) {
        map44.add(movies.getSeriesTitle());
      }
    }
    return map44.subList(0, topmomvie);
  }

  /** getTopStars method. */
  public List<String> getTopStars(int topmovie, String by) {
    List<String> list5 = new ArrayList<>();
    Map<String, Double> map5 = new HashMap<>();
    if (by.equals("rating")) {
      Set<String> set = new HashSet<String>();
      for (Movie m : moviesList) {
        set.add(m.getStar1());
        set.add(m.getStar3());
        set.add(m.getStar2());
        set.add(m.getStar4());
      }
      for (String s : set) {
        double ff = 0;
        int n = 0;
        for (int i = 0; i < moviesList.size(); i++) {
          if (s.equals(moviesList.get(i).getStar1())) {
            ff += moviesList.get(i).getImdbRating();
            n++;
          }
          if (s.equals(moviesList.get(i).getStar2())) {
            ff += moviesList.get(i).getImdbRating();
            n++;
          }
          if (s.equals(moviesList.get(i).getStar3())) {
            ff += moviesList.get(i).getImdbRating();
            n++;
          }
          if (s.equals(moviesList.get(i).getStar4())) {
            ff += moviesList.get(i).getImdbRating();
            n++;
          }
        }
        BigDecimal ffBig = new BigDecimal(ff);
        BigDecimal big = new BigDecimal(n);
        BigDecimal avgBig = ffBig.divide(big, BigDecimal.ROUND_HALF_DOWN, BigDecimal.ROUND_DOWN);
        map5.put(s, avgBig.doubleValue());
      }
      LinkedHashMap<String, Double> m5 = sortMap(map5);
      list5 = new ArrayList<String>(m5.keySet());
    }
    if (by.equals("gross")) {
      Set<String> set = new HashSet<String>();
      for (Movie m : moviesList) {
        set.add(m.getStar1());
        set.add(m.getStar3());
        set.add(m.getStar2());
        set.add(m.getStar4());
      }
      for (String s : set) {
        long gg = 0;
        int n = 0;
        double avg = 0;
        for (int i = 0; i < moviesList.size(); i++) {
          if (s.equals(moviesList.get(i).getStar1()) && moviesList.get(i).getGgross() != 0) {
            gg += moviesList.get(i).getGgross();
            n++;
          }
          if (s.equals(moviesList.get(i).getStar2()) && moviesList.get(i).getGgross() != 0) {
            gg += moviesList.get(i).getGgross();
            n++;
          }
          if (s.equals(moviesList.get(i).getStar3()) && moviesList.get(i).getGgross() != 0) {
            gg += moviesList.get(i).getGgross();
            n++;
          }
          if (s.equals(moviesList.get(i).getStar4()) && moviesList.get(i).getGgross() != 0) {
            gg += moviesList.get(i).getGgross();
            n++;
          }
        }
        if (n != 0) {
          BigDecimal ffBig = new BigDecimal(gg);
          BigDecimal big = new BigDecimal(n);
          BigDecimal avgBig = ffBig.divide(big, BigDecimal.ROUND_HALF_DOWN);
          avg = avgBig.doubleValue();
          map5.put(s, avg);
        }
      }
      LinkedHashMap<String, Double> m55 = sortMap(map5);
      list5 = new ArrayList<String>(m55.keySet());
    }
    return list5.subList(0, topmovie);
  }

  /** searchMovies method. */
  public List<String> searchMovies(String genre, float minRating, int maxRuntime) {
    List<String> map6 = new ArrayList<>();
    Stream<Movie> aall = moviesList.stream();
    List<Movie> list6 = aall.filter(s -> s.getGgenre().contains(genre)
            && (float) s.getImdbRating() >= minRating && Integer.parseInt(s.getRuntime()
            .substring(0, s.getRuntime().length() - 4)) <= maxRuntime).toList();
    for (Movie m : list6) {
      map6.add(m.seriesTitle);
    }
    List<String> map66 = new ArrayList<>();
    for (String s : map6) {
      map66.add(s.replaceAll("^\"*|\"*$", ""));
    }
    Collections.sort(map66);
    return map66;
  }
}
