//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import org.w3c.dom.css.Counter;

void main(){
    String txt = Reader.fileText();
    System.out.println(txt);
    txt = txt.toLowerCase().replaceAll("[,.!«»:?;]", "");;
    System.out.println(txt);
    String[] words = txt.split("\\s+");
    for (String words2:words){
        MapStringAndInt.init(words2);
    }
    for (String words2:words){
        System.out.println(MapStringAndInt.getCount(words2)+" "+ words2);
    }
    Map<String, Integer> countsMap = MapStringAndInt.getCountsWords();

    for (Map.Entry<String, Integer> e : countsMap.entrySet()) {
        System.out.println(e.getValue() + " " + e.getKey());
    }
    MaxHeap heap = new MaxHeap(countsMap.size());
    for (Map.Entry<String, Integer> e : countsMap.entrySet()) {
        heap.add(e.getKey(), e.getValue());
    }
    System.out.println("Самое частое: " + heap.peekWord()
            + " (" + heap.peekFreq() + " раз)");
}
