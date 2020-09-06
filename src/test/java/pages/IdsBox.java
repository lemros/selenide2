package pages;


import java.util.List;
import java.util.TreeMap;

import enumerators.Constants;

import static java.util.Arrays.asList;

public class IdsBox {
    private TreeMap<String, List<String>> ids;

    public IdsBox(String type) {
        switch (type) {
            case "SepaPayment":
                setSepaPayment();
                break;
            case "Login":
                setLogin();
                break;
            default:
                // code block
        }

    }

    public List<String> getParameterList(String name) {
        List<String> parameterList = ids.get(name);
        if (parameterList == null) {
            return ids.get(ids.ceilingKey(name));
        } else {
            return parameterList;
        }
    }

    public List<String> getParameterListStartWith(String name) {
        return ids.get(ids.ceilingKey(name));
    }

    private void setSepaPayment() {
        ids = new TreeMap<String, List<String>>();
        ids.put("ReceiverIban", asList("sepaPayment__receiverIban", Constants.ID_IDENTIFICATOR));
    }

    private void setLogin() {
        ids = new TreeMap<String, List<String>>();
        ids.put("Ippid", asList("username", Constants.ID_IDENTIFICATOR));
        ids.put("Pin", asList("passwordInput", Constants.ID_IDENTIFICATOR));
        ids.put("Token", asList("tokenInput", Constants.NAME_IDENTIFICATOR));
    }


}
