package com.qihoo.study;

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

import java.util.UUID;

/**
 * Created by luoyong on 16-11-28.
 */
public class TestTable {
    public static void main(String[] args) {
        Table<Integer, TextTableColumnKey, String> table = TreeBasedTable.create();
        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();
        table.put(1, new TextTableColumnKey(1, uuid1), "test");
        table.put(1, new TextTableColumnKey(1, uuid1), "test");
        table.put(1, new TextTableColumnKey(1, uuid2), "test");
        table.put(1, new TextTableColumnKey(2, uuid2), "test");
        table.put(1, new TextTableColumnKey(3, uuid2), "test");

        System.out.println(true);

    }


    public static class TextTableColumnKey implements Comparable<TextTableColumnKey> {
        private int index;
        private UUID propertyTypeId;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public UUID getPropertyTypeId() {
            return propertyTypeId;
        }

        public void setPropertyTypeId(UUID propertyTypeId) {
            this.propertyTypeId = propertyTypeId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof TextTableColumnKey)) return false;

            TextTableColumnKey that = (TextTableColumnKey) o;

            if (index != that.index) return false;
            return propertyTypeId != null ? propertyTypeId.equals(that.propertyTypeId) : that.propertyTypeId == null;

        }

        @Override
        public int hashCode() {
            int result = index;
            result = 31 * result + (propertyTypeId != null ? propertyTypeId.hashCode() : 0);
            return result;
        }

        public TextTableColumnKey(int index, UUID propertyTypeId) {
            this.index = index;
            this.propertyTypeId = propertyTypeId;
        }

        @Override
        public int compareTo(TextTableColumnKey o) {
            int indexResult = Integer.compare(this.index, o.index);
            return  indexResult!= 0? indexResult : this.propertyTypeId.compareTo(o.propertyTypeId);
        }
    }
}
