package helpers;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v109.network.Network;
import org.openqa.selenium.devtools.v109.network.model.Request;
import org.openqa.selenium.devtools.v109.network.model.RequestId;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static setup.DriverFactory.getDriverThread;

public class ChromeDevToolsHelper {

    //Hashmaps to collect network data
    static Map<String, String> requestsMap = new HashMap<>();
    static Map<String, String> responseBodyMap = new HashMap<>();
    static Map<String, String> responseHeaderMap = new HashMap<>();
    static DevTools devTools;

    public static void interceptNetworkTraffic() {

        final RequestId[] requestIds = new RequestId[1];
        devTools = ((HasDevTools) getDriverThread()).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),
                Optional.empty(),
                Optional.empty()));

        //Intercepting requests
        devTools.addListener(Network.requestWillBeSent(), requestSent -> {
            Request request = requestSent.getRequest();
            String requestURL = request.getUrl();
            String requestMethod = request.getMethod();

            if (requestURL.contains("https://plive.api.krisp.ai/") && requestMethod.matches("POST|GET|PUT|PATCH|DELETE")) {
                RequestId requestId = requestSent.getRequestId();
                requestsMap.put(requestId.toString(), "ID" + requestId + "Request URL => " +
                        requestURL + " <= Request Method => " +
                        requestMethod + " <= Request Headers => " +
                        request.getHeaders().toString() +
                        " <= Request Body =>" + request.getPostData());
            }
        });

        //Intercepting response body
        devTools.addListener(Network.loadingFinished(), responseFinished -> {
            RequestId responseId = responseFinished.getRequestId();
            if (requestsMap.containsKey(responseId.toString())) {
                requestIds[0] = responseId;
                String responseBody = devTools.send(Network.getResponseBody(requestIds[0])).getBody();
                responseBodyMap.put(responseId.toString(), "    Response Body =>" + responseBody);
            }
        });

        //Intercepting Response Header
        devTools.addListener(Network.responseReceived(), responseReceived -> {

            String responseUrl = responseReceived.getResponse().getUrl();
            String responseReceivedType = responseReceived.getType().toString();

            if (responseUrl.contains("https://plive.api.krisp.ai/")) {
                int status = responseReceived.getResponse().getStatus();
                RequestId id = responseReceived.getRequestId();
                requestIds[0] = responseReceived.getRequestId();
                responseHeaderMap.put(id.toString(), "  Response URL => " +
                        responseUrl + " <= Response Status Code " +
                        status + " <= Response Body =>" + "responseBody");
            }
        });
    }

    public static void writeNetworkLogsIntoFile(String methodName) {
        try {
            File fileToCreate = new File("networkLogs");
            fileToCreate.mkdirs();
            FileWriter myWriter = new FileWriter("networkLogs/" + methodName + ".txt");
            for (String id : requestsMap.keySet()) {
                try {
                    String value = requestsMap.get(id);
                    myWriter.write(value);
                    myWriter.write("\n");
                    myWriter.write(responseHeaderMap.get(id));
                    myWriter.write("\n");
                    myWriter.write(responseBodyMap.get(id));
                    myWriter.write("\n");
                } catch (NullPointerException e) {
                    myWriter.write("\n");
                    myWriter.write("!!!Response wtih " + id + "did not logged");
                    myWriter.write("\n");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred in writing network logs");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        requestsMap.clear();
        responseBodyMap.clear();
        responseBodyMap.clear();
    }
}

