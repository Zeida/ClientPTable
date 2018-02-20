/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientptable;

/**
 *
 * @author Ana Plácido
 */
public class ClientPTable {

    public static void main(String[] args) {
        String text = "Gold";
        String response1 = getAtomicNumber(text);
        String response2 = getElementSymbol(text);
        if (!response1.equals("<NewDataSet />")) {
            String atomicNumber = parseResponse(response1, "</AtomicNumber>");
            System.out.println("Gold atomic number is: " + atomicNumber);
        }
        if (!response2.equals("<NewDataSet />")) {
            String elementSymbol = parseResponse(response2, "</Symbol>");
            System.out.println("Gold element symbol is: " + elementSymbol );

        }

    }

    private static String getAtomicNumber(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getAtomicNumber(elementName);
    }

    private static String parseResponse(String response, String endTag) {
        String beginTag = endTag.replace("/", "");
        final int from = response.indexOf(beginTag);
        final int to = response.lastIndexOf(endTag);
        final String beginTagAndContent = response.substring(from, to);
        return beginTagAndContent.substring(beginTagAndContent.indexOf(">") + 1);
    }

    private static String getElementSymbol(java.lang.String elementName) {
        net.webservicex.Periodictable service = new net.webservicex.Periodictable();
        net.webservicex.PeriodictableSoap port = service.getPeriodictableSoap();
        return port.getElementSymbol(elementName);
    }
}
