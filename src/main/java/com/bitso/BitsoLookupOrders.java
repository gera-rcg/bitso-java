package com.bitso;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.bitso.exchange.BookOrder;

public class BitsoLookupOrders {

    public ArrayList<BookOrder> list;

    public BitsoLookupOrders(JSONArray obj) {
        list = new ArrayList<BookOrder>(obj.length());

        for (int i = 0; i < obj.length(); i++) {
            JSONObject o = obj.getJSONObject(i);
            BookOrder order = Bitso.processBookOrderJSON(o.toString());
            if (order != null) {
                list.add(order);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("====LOOKUP_ORDERS====");
        if (list != null) {
            for (BookOrder o : list) {
                sb.append(o.toString());
            }
        }
        return sb.toString();
    }
}
