package com.tobianoapps.website.model

import androidx.compose.runtime.Composable
import com.tobianoapps.website.model.Faq.DataSources.FaqAnswerSpan
import com.tobianoapps.website.model.Faq.DataSources.Li
import com.tobianoapps.website.model.Faq.DataSources.NewLine
import com.tobianoapps.website.model.Faq.DataSources.mailtoSunnySideHelp
import com.tobianoapps.website.model.Faq.DataSources.sunnySideHelpEmail
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

/**
 * TODO: this works but ideally we'd be able to inject markdown from sections of
 *  [resources/markdown/android/sunnyside/Faq.old]. It theoretically should be possible to do this
 *  with kotlin/js interop and a jas markdown parser so revisit when time allows.
 */
sealed class Faq(val question: String, val answer: @Composable (Modifier) -> Unit) {
    @Composable
    internal fun FaqAnswerSpan(
        modifier: Modifier = Modifier,
        content: @Composable () -> Unit
    ) {
        Span(modifier.fillMaxWidth().toAttrs()) { content() }
    }

    @Composable
    internal fun NewLine(modifier: Modifier = Modifier) = Column(modifier) { SpanText(" ") }

    @Composable
    internal fun Li(
        modifier: Modifier = Modifier,
        items: List<String>,
        bulleted: Boolean = false
    ) {
        Column(modifier) {
            items.forEachIndexed { index, s ->
                SpanText(
                    " " + if (bulleted) "• " else "${index + 1}. " + s
                )
            }
        }
    }

    val mailtoSunnySideHelp = "mailto:sunnyside_help@tobianoapps.com?subject=Feedback for Sunny Side Android"
    val sunnySideHelpEmail = "sunnyside_help@tobianoapps.com"

    data object InaccurateUvIndex : Faq(
        question = "UV index is inaccurate",
        answer = { modifier ->
            FaqAnswerSpan(modifier) {
                Text("Sunny Side uses the ")
                Link(path = "https://www.met.no/", text = "Meteorologisk Institute's")
                Text(" API for its data. ")
                Link(path = "mailto:klima@met.no", text = "Feel free to report any inaccuracy to them.")
            }
        }
    )

    data object DataSources : Faq(
        question = "Can you add more data sources?",
        answer = { modifier ->
            FaqAnswerSpan(modifier) {
                Text("The ")
                Link(path = "https://www.met.no/", text = "Meteorologisk Institute's")
                Text(" API was the only free, reliable source providing current UV index and forecast. Other sources were either unreliable or required a recurring fee. If better data sources pop up, they will be considered, but in the meantime this is the best option for Sunny Side.")
            }
        }
    )

    data object Premium : Faq(
        question = "Will you be adding a premium / paid version / subscription?",
        answer = { modifier ->
            FaqAnswerSpan(modifier) {
                Text("I have not built Sunny Side as a profit generating project. I intend to keep it free. The downside is that I will have limited time to add new features or maintain it. I will do my best to update Sunny Side if any breaking change is introduced by new Android versions.")
            }
        }
    )

    data object FeatureRequest : Faq(
        question = "Can you add feature x, y and z?",
        answer = { modifier ->
            FaqAnswerSpan(modifier) {
                Text("Please share your idea by sending an email to ")
                Link(
                    path = mailtoSunnySideHelp,
                    text = "$sunnySideHelpEmail. "
                )
                Text("Just keep in mind that this free app is developed and maintained in my spare time so I cannot guarantee that any new feature will actually be implemented.")
            }
        }
    )

    data object LocationTracking : Faq(
        question = "Do you track my location?",
        answer = { modifier ->
            FaqAnswerSpan(modifier) {
                Text("The short answer is: Sunny Side does NOT track your location but third-parties may.")
                NewLine()
                Text("The long answer is: Sunny Side stores your location on your device only. There is no analytics, ads or any tracking logic implemented in the app. However, the app needs to communicate your location to the ")
                Link(path = "https://www.met.no/", text = "Meteorologisk Institute's")
                Text(" API to get UV index data back. Please refer to their ")
                Link(path = "https://www.met.no/en/About-us/privacy", text = "privacy policy")
                Text(" to learn more.")
                NewLine()
                Text("Also, getting your location either through a location request via GPS or via the ")
                Link(path = "https://cloud.google.com/maps-platform/places", text = "Google Places SDK")
                Text(" shares some of your data with Google. Please refer to ")
                Link(path = "https://policies.google.com/privacy)", text = "Google's privacy policy center")
                Text(" to learn more.")
            }
        }
    )

    data object WidgetUpdate : Faq(
        question = "Widget not updating?",
        answer = { modifier ->
            FaqAnswerSpan(modifier) {
                Text("Widgets require that you grant background and works better with precise location permission.")
                NewLine()
                Text("To check these:")
                NewLine()
                Li(
                    items = listOf(
                        "Go to Settings -> Apps -> Sunny Side -> Permissions -> Location",
                        "Select \"Allow all the time\" AND \"Use precise location\"",
                        "Delete and re-add widgets"
                    )
                )
                NewLine()
                Text("If you've been switching launchers, make sure you also delete widgets on launchers that you're not using.")
                NewLine()
                Text("If that does not work, try clearing the app's data and cache:")
                NewLine()
                Li(
                    items = listOf(
                        "Go to Settings -> Apps",
                        "Click on See all apps",
                        "Look for and click on Sunny Side",
                        "Click on Storage & cache",
                        "Click on Clear cache and Clear storage"
                    )
                )
                NewLine()
                Text("If that does not work, try deleting Sunny Side, reboot your phone and re-install the app.")
                NewLine()
                Text("Unfortunately some manufacturers implement overly aggressive battery optimization that breaks basic functionality. This is especially true if you're using a Samsung, OnePlus, Huawei or Xiaomi device. To learn more, as well as to view detailed steps for possible fixes, please click on the manufacturer of your device on this website: ")
                Link(path = "https://dontkillmyapp.com/", text = "https://dontkillmyapp.com/")
                NewLine()
                Text("Please don't hesitate to send an email to ")
                Link(
                    path = mailtoSunnySideHelp,
                    text = sunnySideHelpEmail
                )
                Text(" to report bugs or if you need any help troubleshooting issues.")
            }
        }
    )

    data object WidgetBattery : Faq(
        question = "Widget battery usage?",
        answer = { modifier ->
            FaqAnswerSpan(modifier) {
                Text("Due to the time-sensitive nature of UV data, and restrictions in the Android OS, a running service is required to keep the widgets up to date.\n")
                NewLine()
                Text("I have benchmarked Sunny Side's widgets against acclaimed, popular apps and found similar or better performance.")
            }
        }
    )

    data object LocationFailOrSlow : Faq(
        question = "Location fail / slow update?",
        answer = { modifier ->
            FaqAnswerSpan(modifier) {
                Text("GPS location is fetched through Google Play Services. It may take up to 30 seconds for a location refresh")
                NewLine()
                Text("There are a few things you can try to improve refresh speed and reliability:")
                NewLine()
                Li(
                    items = listOf(
                        "grant precise location permission",
                        "as a quick check, go outside and open Google Maps. Check if you can refresh your location in the app. Then try updating your location in Sunny Side",
                        "make sure Google Play Services are up-to-date and not blocked in any way",
                        "go to \"Location Services\" in system settings and make sure \"Google Location Accuracy\", \"Wi-Fi Scanning\" and \"Bluetooth Scanning\" are on",
                        "do not spoof your location",
                        "do not use a VPN, ad blocker or other networking restrictions"
                    )
                )
                NewLine()
                Text("As an alternative, instead of using GPS location, use the ")
                Link(
                    path = "https://tobianoapps.com/android/sunnyside/images/sunnyside_search_location.png",
                    text = "search function"
                )
                Text(" instead. Location won't update automatically but as long as you're not travelling long distances, UV data will remain accurate.")
            }
        }
    )

    data object GooglePlayStoreHelp : Faq(
        question = "I asked for help in the Google Play Store review section so why are you asking me to send an email?",
        answer = { modifier ->
            FaqAnswerSpan(modifier) {
                Text("The review section of the Google Play Store has a 350 character limit, does not allow sharing url links, images, videos or files of any type. Conversation history is also difficult to read.")
                Link(
                    path = mailtoSunnySideHelp,
                    text = " Email"
                )
                Text(" is the best way to provide support.")
            }
        }
    )

    data object OtherProblems : Faq(
        question = "Network, location, data empty? Problem not listed here?",
        answer = { modifier ->
            FaqAnswerSpan(modifier) {
                Text("Please send an email to ")
                Link(path = mailtoSunnySideHelp, text = sunnySideHelpEmail)
                Text(" and I'd be happy to help troubleshoot or fix a bug if there is one to fix. The Google Play Store review section is not the right place for troubleshooting these issues.")
                NewLine()
                Text("A few things you can check in the meantime are:")
                Li(
                    items = listOf(
                        "make sure that you are using the latest version of Sunny Side by checking for updates in the Google Play Store",
                        "if you are using a VPN, or any ad blocking software, turn them off and try again",
                        "make sure that you have a strong, consistent internet connection",
                        "for location, please see the section above entitled \"Location slow update\"",
                        "make sure your device system time is correct. The best way to do so is to: go to System Settings -> System -> Date & Time and set every option to \"automatic\" or \"network-provided\". Then restart your device."
                    )
                )
            }
        }
    )

    data object CityAsCoordinate : Faq(
        question = "City name / region displayed as coordinates",
        answer = { modifier ->
            FaqAnswerSpan(modifier) {
                Text("On rare occasions, fetching city name & region may fail. Instead of showing nothing, shortened coordinates will be displayed.")
                NewLine()
                Text(
                    "A few things you can check in the meantime are:"
                )
                Li(
                    items = listOf(
                        "restart the app",
                        "make sure that you have a strong, consistent internet connection",
                        "make sure Google Play Services are up to date and not blocked in any way",
                        "make sure that you are using the latest version of Sunny Side by checking for updates in the Google Play Store",
                        "if you are using a VPN, or any ad blocking software, turn them off and try again"
                    )
                )
            }
        }
    )

    companion object {
        val all = listOf(
            InaccurateUvIndex,
            DataSources,
            Premium,
            FeatureRequest,
            LocationTracking,
            WidgetUpdate,
            WidgetBattery,
            LocationFailOrSlow,
            GooglePlayStoreHelp,
            CityAsCoordinate,
            OtherProblems

        )
    }
}