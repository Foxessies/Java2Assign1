import java.util.*;
import java.util.stream.Collectors;

public class Student {
    /**
     * 去除字符串首尾两端指定的字符
     * */
//    public Map<List<String>, Integer> getCoStarCount(){
//        Map<List<String>, Integer> map3=new HashMap<>();  int y=0;
//        Map<List<String>, Integer> map33 =new HashMap<>();
//        for(int b=0;b<Movielist.size();b++){
//            List<List<String>> l=new LinkedList<>() {};
//            List<String> name=new ArrayList<>();
//
//            List<String> s= new ArrayList<>();s.add(Movielist.get(b).getStar1());s.add(Movielist.get(b).getStar2());
//            l.add(s.stream().sorted().collect(Collectors.toList()));
//            List<String> sa= new ArrayList<>();sa.add(Movielist.get(b).getStar1());sa.add(Movielist.get(b).getStar3());
//            l.add(sa.stream().sorted().collect(Collectors.toList()));
//            List<String> sd= new ArrayList<>();sd.add(Movielist.get(b).getStar1());sd.add(Movielist.get(b).getStar4());
//            l.add(sd.stream().sorted().collect(Collectors.toList()));
//            List<String> sf= new ArrayList<>();sf.add(Movielist.get(b).getStar2());sf.add(Movielist.get(b).getStar3());
//            l.add(sf.stream().sorted().collect(Collectors.toList()));
//            List<String> sg= new ArrayList<>();sg.add(Movielist.get(b).getStar2());sg.add(Movielist.get(b).getStar4());
//            l.add(sg.stream().sorted().collect(Collectors.toList()));
//            List<String> sq= new ArrayList<>();sq.add(Movielist.get(b).getStar3());sq.add(Movielist.get(b).getStar4());
//            l.add(sq.stream().sorted().collect(Collectors.toList()));
//
////            l.add(new LinkedList<>(Arrays.asList(Movielist.get(b).getStar3(),Movielist.get(b).getStar2())));l.add(new LinkedList<>(Arrays.asList(Movielist.get(b).getStar4(),Movielist.get(b).getStar2())));l.add(new LinkedList<>(Arrays.asList(Movielist.get(b).getStar4(),Movielist.get(b).getStar3())));
//
//            outer:for(int i=0;i<6;i++){
//                int x=1;
//                Set<List<String>> set=map3.keySet();
//                for(List<String> sset:set){
//                    if(sset.equals(l.get(i))){
//                        break outer;
//                    }
//                }
//
//                for(int a=1+b;a<Movielist.size();a++){
//                    List<List<String>> ll=new LinkedList<>();
//                    List<String> n= new ArrayList<>();n.add(Movielist.get(a).getStar1());n.add(Movielist.get(a).getStar2());
//                    ll.add(n.stream().sorted().collect(Collectors.toList()));
////               ll.add(new LinkedList<>(Arrays.asList(Movielist.get(a).getStar3(),Movielist.get(a).getStar2())));ll.add(new LinkedList<>(Arrays.asList(Movielist.get(a).getStar4(),Movielist.get(a).getStar3())));ll.add(new LinkedList<>(Arrays.asList(Movielist.get(a).getStar3(),Movielist.get(a).getStar2())));
//                    List<String> nn= new ArrayList<>();nn.add(Movielist.get(a).getStar1());nn.add(Movielist.get(a).getStar3());
//                    ll.add(nn.stream().sorted().collect(Collectors.toList()));
//                    List<String> nv= new ArrayList<>();nv.add(Movielist.get(a).getStar1());nv.add(Movielist.get(a).getStar4());
//                    ll.add(nv.stream().sorted().collect(Collectors.toList()));
//                    List<String> nz= new ArrayList<>();nz.add(Movielist.get(a).getStar2());nz.add(Movielist.get(a).getStar3());
//                    ll.add(nz.stream().sorted().collect(Collectors.toList()));
//                    List<String> nx= new ArrayList<>();nx.add(Movielist.get(a).getStar2());nx.add(Movielist.get(a).getStar4());
//                    ll.add(nx.stream().sorted().collect(Collectors.toList()));
//                    List<String> nc= new ArrayList<>();nc.add(Movielist.get(a).getStar3());nc.add(Movielist.get(a).getStar4());
//                    ll.add(nc.stream().sorted().collect(Collectors.toList()));
//
//                    for(int k=0;k<6;k++){
//                        if (l.get(i).equals(ll.get(k))) {
//                            x++;
//                        }
//                    }
//                }     map3.put(l.get(i),x);
//            }
//        }
//        Map<List<String>, Integer> m1 = new LinkedHashMap<>();
//        map3.entrySet().stream()
//                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue())).toList().forEach(e -> m1.put(e.getKey(), e.getValue()));
//
//        System.out.println(m1);
//        return m1;
//    }
    public static void main(String[] args) {
            Map<Integer,Integer>  map = new HashMap<Integer,Integer>();
        Map<Integer, Integer> list1=new HashMap<>();
            map .put(1, 2);
            map .put(1, 3);
            map .put(2, 3);
        ListIterator<Map.Entry<Integer,Integer>> li = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet()).listIterator(map.size());
        Map.Entry<Integer, Integer> entry = null;
            while(li.hasPrevious()) {
                entry = li.previous();
                list1.put(entry.getKey(),entry.getValue());
            }
            System.out.println(list1);
        }
    }

