package prixma.datacollector.compression;

import java.util.Collections;
import java.util.Comparator;

public enum RecordOrder implements Comparator<Record> {

	ByTimestamp() {
        public int compare(Record one, Record other) {
           return one.getTimestamp().compareTo(other.getTimestamp());
        }
     },

     ByValue() {
         public int compare(Record one, Record other) {
            return one.getValue().compareTo(other.getValue());
         }
      };
      
    
     public Comparator<Record> asc() {
        return this;
     }

     public Comparator<Record> desc() {
        return Collections.reverseOrder(this);
     }

}

