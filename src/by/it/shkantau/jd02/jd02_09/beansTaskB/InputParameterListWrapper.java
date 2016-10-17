package by.it.shkantau.jd02.jd02_09.beansTaskB;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.LinkedList;
import java.util.List;

/**
 * Helper class to wrap a list of Parameter. This is used for saving the
 * list of inputParameters to XML.
*/
@XmlRootElement(name = "parameters")
class InputParameterListWrapper {

    private List<Parameter> parametersList = new LinkedList<>();

    @XmlElement(name = "parameter")
    List<Parameter> getParameterListWrapper() {
        return parametersList;
    }

    public void setParameterListWrapper(List<Parameter> parametersList) {
        this.parametersList = parametersList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Parameter p: parametersList) {
            sb.append(p).append("\n");
        }
        return sb.toString();
    }
}


