package com.javarush.test.level22.lesson09.task02;

import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static StringBuilder getCondition(Map<String, String> params) {
        //System.out.println(params);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getValue()!=null) {
                stringBuilder.append(entry.getKey() + " = '" + entry.getValue() + "\'");
                stringBuilder.append(" and ");
            }
        }

        if (stringBuilder.toString().length()>5){
            String string = stringBuilder.toString().substring(0,stringBuilder.length()-5);
        result.append(string);
        //result.append("\"");
        }
        //System.out.println(result.toString());
        return result;
    }


  /*  public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
        map.put("name",null);
        map.put("country", "Ukraine");
        //map.put("city", "Kiev");
        map.put("age", null);
        map.put("erw", null);
        //map.put("city2", "Kiev");

        getCondition(map);
    }*/
}
