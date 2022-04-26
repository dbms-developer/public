import com.launchdarkly.client.*;

public class LDFeatureFlag {

    public static void main(String[] args) {
        LDClient ldclient = new LDClient("sdk-key-123");

        // Hard coded user attributes in this sample would be variables in the real world.
        LDUser user = new LDUser.Builder("bgomes@launchdarkly.com") // Key is required
            // Built in Fields -- Optional
            .firstName("Breno")
            .lastName("Gomes")
            .country("IE")
            .ip("127.0.0.1")

            // Attributes Marked Private will not be Sent to LaunchDarkly
            .privateEmail("bgomes@launchdarkly.com")


            // Arbitrary Custom Metadata can be Passed Along
            .customPrivate("region", "EU")
            .custom("Group", "Beta")
            .custom("Country", "Ireland")
            .custom("app_version", 4.2)
            .custom("group_member", "Premium")
            .custom("RequestHeader", "v3")
            .custom("BrowserType", "Chrome")
            .build();

        //Evaluate the feature flag against the user
        boolean showFeature = ldClient.boolVariation("show-widgets", user, false);

        if (showFeature) {
            // Application code to show the feature
            //newCode();
            System.out.println("Feature is ENABLED");
        } else {
            // Application code to run if the feature is off
            //oldCode();
            System.out.println("Feature is DISABLED");
        }
    }
}
