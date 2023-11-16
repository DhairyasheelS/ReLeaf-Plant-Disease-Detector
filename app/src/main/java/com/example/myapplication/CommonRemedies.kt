package com.example.myapplication

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class CommonRemedies : AppCompatActivity() {
    private lateinit var resTextView: TextView
    private lateinit var imageView: ImageView
    private lateinit var  textview2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_common_remedies)
        resTextView = findViewById(R.id.resultText)
        imageView = findViewById(R.id.imageView4)
        textview2 = findViewById(R.id.textView4)

        // Retrieve the result from the intent extras
        val resultText = intent.getStringExtra("text")
        resTextView.text = resultText

        if (resultText != null) {
            when {
                resultText.contains("apple scab", ignoreCase = true) -> {
                    val remedies =
                            "Fungicide Sprays:\n" +
                            "Copper-based fungicides and sulfur - based fungicides are commonly used for organic control of apple scab, while synthetic fungicides may also be used.\n" +
                            "Pruning and Thinning:\n" +
                            "Pruning helps to open up the canopy, allowing better sunlight penetration and air circulation. Thinning the fruit also reduces the density of fruit on the tree, which can help prevent the spread of the disease.\n" +
                            "Sanitation and Fallen Leaf Removal:\n" +
                            "This helps break the disease's life cycle and reduces the source of infection for the next year.\n"
                    textview2.text = remedies
                }
                resultText.contains("apple black rot", ignoreCase = true) -> {
                    val remedies =
                            "Pruning and Thinning:\n" +
                            "Remove any dead or infected branches, and thin out crowded areas to allow better airflow. This can help prevent the disease from spreading within the tree.\n" +
                            "Fungicide Applications:\n" +
                            "Copper-based fungicides and sulfur-based fungicides are often effective in controlling the disease. You should apply these fungicides in the spring, just before the apple tree blooms and continue at regular intervals throughout the growing season. Be sure to use fungicides labeled for apple trees and consult with a local agricultural extension office or nursery for specific recommendations for your region.\n" +
                            "Sanitation and Disease Management:\n" +
                            "Collect and remove any fallen leaves, fruit, or infected plant material from the ground, as these can serve as a source of fungal spores.\n" +
                            "Remove any mummified fruit that may be hanging on the tree, as these can harbor the disease.\n" +
                            "Avoid overhead watering, which can promote the spread of the disease by splashing fungal spores onto the tree.\n" +
                            "Space your apple trees adequately to allow for good air circulation.\n" +
                            "Ensure that the trees receive full sunlight, which can help dry the foliage and reduce humidity.\n"
                    textview2.text = remedies
                }
                resultText.contains("apple cedar apple rust", ignoreCase = true) -> {
                    val remedies =
                            "Fungicides\n" +
                            "Fungicides with the active ingredient myclobutanil are most effective.\n" +
                            "Bio fungicides\n" +
                            "A strain of bacteria called Bacillus subtilis is effective at treating cedar apple rust. " +
                            "It's sold commercially as CEASE Biological Fungicide.\n"
                    textview2.text = remedies
                }

                resultText.contains("potato late blight", ignoreCase = true) -> {
                    val remedies =
                                "1) Remove volunteers from the garden prior to planting and space plants far enough apart to allow for plenty of air circulation.\n" +
                                "2) Apply a copper-based fungicide (2 oz/gallon of water) every 7 days or less, following heavy rain or when the amount of disease is increasing rapidly.\n" +
                                "3) If possible, time applications so that at least 12 hours of dry weather follows application."

                    textview2.text = remedies
                }
                resultText.contains("CHERRY (SOUR) POWDERY MILDEW", ignoreCase = true) -> {
                    val remedies =
                                "Pruning and Thinning:\n" +
                                "This helps reduce humidity around the tree, making it less favorable for powdery mildew to develop.\n" +
                                "Thin out branches and foliage to allow more light to penetrate the canopy, which can inhibit the growth of the fungus.\n" +
                                "Fungicidal Sprays: \n" +
                                "Use a fungicidal spray specifically designed to control powdery mildew. Some common options include sulfur-based fungicides, neem oil, or horticultural oils.\n" +
                                "Apply the fungicide as soon as you notice signs of powdery mildew or at the beginning of the growing season as a preventive measure.\n"

                    textview2.text = remedies
                }
                resultText.contains("CORN MAIZE CERCOSPORA LEAF SPOT & GRAY LEAF SPOT", ignoreCase = true) -> {
                    val remedies =
                                "Crop Rotation: Rotate your corn crops with non-host plants (plants that are not susceptible to these diseases) to reduce the buildup of pathogens in the soil. " +
                                "This can help break the disease cycle.\n" +
                                "Fungicide ApplicationFungicides can help control the diseases when applied according to recommended guidelines.\n" +
                                "Proper Plant Spacing: Ensure proper plant spacing to promote air circulation between plants. Good airflow can help reduce the humidity that favors disease development.\n"

                    textview2.text = remedies
                }
                resultText.contains("GRAPE BLACK ROT IS A FUNGAL DISEASE THAT ATTACKS GRAPE VINES", ignoreCase = true) -> {
                    val remedies =
                                "Fungicidal Sprays: \n" +
                                "Fungicides are often used to prevent and manage Grape Black Rot. Some common fungicides for grapevines include captan, mancozeb, and myclobutanil. " +
                                "These should be applied at specific times during the growing season, as recommended by local agricultural extension services, to be most effective.\n" +
                                "Pruning :\n" +
                                "Proper pruning and can help increase air circulation and sunlight penetration within the grapevine canopy. " +
                                "This reduces the humidity and moisture levels, making it less favorable for the fungus to thrive. " +
                                "Prune away infected plant parts and ensure a balanced vine canopy to improve air movement.\n"

                    textview2.text = remedies
                }
                resultText.contains("Peach leaf curl", ignoreCase = true) -> {
                    val remedies =
                                "Leaf curl can be controlled by applying sulphur or copper-based fungicides that are labelled for use on peaches and nectarines. " +
                                "Spray the entire tree after 90% of the leaves have dropped in the fall and again in the early spring, just before the buds open. " +
                                "For best results, trees should be sprayed to the point of runoff or until they start dripping.\n" +
                                "2)\tIf disease problems are severe, maintain tree health and Vigor by cutting back more fruit than normal, watering regularly (avoiding wetting the leaves if possible) " +
                                "and apply an organic fertilizers high in nitrogen.\n"

                    textview2.text = remedies
                }
                resultText.contains("Peach bacterial spot", ignoreCase = true) -> {
                    val remedies =
                                "1)\tApply chemical sprays that contain copper during the dormant period, and continue to apply them during the spring " +
                                "and summer months to reduce the spread of the disease and the amount of overwintering inoculum for the following spring. " +
                                "Homeowners have fewer chemical spray options. \n" +
                                "2)\tAvoid tree planting in sandy soil. It may harm the leaves if wind starts blowing around.\n"

                    textview2.text = remedies
                }
                resultText.contains("Pepper bell bacterial spot", ignoreCase = true) -> {
                    val remedies =
                                "1)\tCopper sprays can be used to control bacterial leaf spot, but they are not as effective when used alone on a continuous basis. \n" +
                                "2)\tBeneficial microorganisms containing products, such as Serenade and Sonata, can reduce pepper leaf spot if used proactively. " +
                                "3)\tonce the disease has spread to more than 5% of plants, these products can’t suppress the disease.\n"

                    textview2.text = remedies
                }
                resultText.contains("Mosaic Virus On Peppers", ignoreCase = true) -> {
                    val remedies =
                                "1)\tRemove affected plants. There are no effective treatments for viruses. If you suspect mosaic virus, remove the pepper plants from from affected fruits.\n" +
                                "2)\tUse a pure neem oil solution with castile soap and water and spray plants to deal with these pests.\n" +
                                "3)\tthe garden and burn them if possible. The fruits are still safe to eat, but the seeds can carry the virus, so do not save seeds \n"

                    textview2.text = remedies
                }
                resultText.contains("Potato early blight", ignoreCase = true) -> {
                    val remedies =
                                "1)\tUse adequate nitrogen levels and low phosphorus levels to reduce disease severity. See current recommendations.\n" +
                                "2)\tAvoid overhead irrigation and allow for sufficient aeration between plants to allow the foliage to dry as quickly as possible. Practice a two-year crop rotation. " +
                                "3)\tThat is, do not replant potatoes or other crops in this family for two years after a potato crop has been harvested.\n"

                    textview2.text = remedies
                }
                resultText.contains("squash powdery mildew", ignoreCase = true) -> {
                    val remedies =
                                "1)\tFirst, remove infected leaves as soon as you detect the white powdery spots. If any plants show severe symptoms, remove them altogether. \n" +"\n"
                                "2)\tOne of the most effective sprays is neem oil an extract from the tropical neem tree. It's a good control for mild to moderate powdery mildew infections.\n"+"\n"

                    textview2.text = remedies
                }
                resultText.contains("Strawberry leaf scorch", ignoreCase = true) -> {
                    val remedies =
                                "1)\tSince this fungal pathogen overwinters on the fallen leaves of infected plants, proper garden sanitation is key. " +"\n"
                                "2)\tThis includes the removal of infected garden debris from the strawberry patch, as well as the frequent establishment of new strawberry transplants. " +"\n"
                                "3)\tThe creation of new plantings and strawberry patches is key to maintaining a consistent strawberry harvest, as older plants are more likely to show signs of severe infection.\n" + "\n"+
                                "4)\tIncrease air circulation to encourage leaf drying. Consider resistant cultivars. Use fungicides if disease becomes severe.\n"

                    textview2.text = remedies
                }
                resultText.contains("Tomato bacterial Spot", ignoreCase = true) -> {
                    val remedies =
                                "1)\tCultural controls and some copper formulations are acceptable for use on organically certified produce.\n" + "\n"
                                "2)\tCopper-containing bactericides provide partial disease control. " + "\n"
                                "3)\tApply at first sign of disease and repeat at 10- to 14-day intervals when warm, moist conditions prevail. " + "\n"+
                                "Copper is strictly a protectant and must be applied before an infection period occurs\n"

                    textview2.text = remedies
                }
                resultText.contains("Tomato early blight", ignoreCase = true) -> {
                    val remedies =
                                "1)\tTrellis tomatoes to increase air flow and to prevent spores splashing up from the soil.\n" + "\n"+
                                "2)\tPrune the bottom most leaves as the plant grows. " + "\n"+
                                "3)\tThese leaves are usually more infected than the upper parts of the plant.\n"

                    textview2.text = remedies
                }
                resultText.contains("Tomato late blight", ignoreCase = true) -> {
                    val remedies =
                                "1)\tApply a copper based fungicide (2 oz/ gallon of water) every 7 days or less, following heavy rain or when the amount of disease is increasing rapidly. " + "\n"+
                                "2)\tIf possible, time applications so that at least 12 hours of dry weather follows application.\n" + "\n"+
                                "3)\tUsed as a foliage spray, Organised Plant Doctor will work its way through the entire plant to prevent fungal "

                    textview2.text = remedies
                }
                resultText.contains("Tomato leaf Mould", ignoreCase = true) -> {
                    val remedies =
                                "1)\tTry to avoid wetting the leaves when watering. This is particularly important when watering in the evening, as the leaves may then stay wet throughout the night.\n" +"\n"
                                "2)\tPick off infected leaves as soon as they are seen, and dispose of affected plants and all debris at the end of the season. " + "\n"+
                                "3)\tDisinfect the greenhouse structure with a product such as Jeyes Fluid (tar oils). Apply according to the manufacturer’s instructions…\n"

                    textview2.text = remedies
                }
                resultText.contains("Tomato Septoria leaf spot", ignoreCase = true) -> {
                    val remedies =
                                "1)\tRemove diseased leaves. If caught early, the lower infected leaves can be removed and burned or destroyed. However, removing leaves above where fruit has formed will weaken the plant and expose fruit to sunscald. " + "\n"
                                "2)\tAt the end of the season, collect all foliage from infected plants and dispose of or bury. Do not compost diseased plants.\n" + "\n"
                                "3)\t Use fungicidal sprays. If the above measures do not control the disease, you may want to use fungicidal sprays. Fungicides will not cure infected leaves, but they will protect new leaves from becoming infected. \n" + "\n"+
                                "4)\tApply at 7 to 10 day intervals throughout the season. Apply chlorothalonil, mancozeb, or a copper-based fungicide, such as Bordeaux mixture, copper hydroxide, copper sulphate, or copper oxychloride sulphate. Follow harvest restrictions listed on the pesticide label.\n"

                    textview2.text = remedies
                }
                resultText.contains("Tomato spider mites", ignoreCase = true) -> {
                    val remedies =
                                "1)\tinsecticidal soap-Complete coverage, especially of undersides of leaves, is essential. " + "\n"
                                "2)\tRepeat applications may be required. Some formulations are OMRI-listed for organic use.\n" + "\n"+
                                "3)\tplant-derived essential oils (cottonseed, clove, garlic, etc.) have proven effective against mites. Some formulations are OMRI-listed for organic use.\n"

                    textview2.text = remedies
                }resultText.contains("Tomato Target spot", ignoreCase = true) -> {
                val remedies =
                            "1)\tMany fungicides are registered to control of target spot on tomatoes. Growers should consult regional disease management guides for recommended products. " + "\n"
                            "2)\tProducts containing chlorothalonil, mancozeb, and copper oxychloride have been shown to provide good control of target spot in research trials.The strobilurin fungicides azoxystrobin and pyraclostrobin, the fungicide boscalid, and the systemic acquired resistance (SAR) elicitor acibenzolar-S-methyl have also been shown to provide good control of target spot.\n" + "\n"+
                            "3)\tThis is especially important when using strobilurin fungicides because they are at high risk for resistance development.\n"

                textview2.text = remedies
                }
                resultText.contains("Tomato yellow leaf curl virus", ignoreCase = true) -> {
                    val remedies =
                                "1)\tdo not move infected or host plants or seedlings, or infected SLW\n" + "\n"+
                                "2)\tplant new crops as far away as practicable from existing crops which may harbour the virus and its carrier, silver-leaf white-fly.\n"

                    textview2.text = remedies
                }
                resultText.contains("Tomato mosaic virus", ignoreCase = true) -> {
                    val remedies =
                                "1)\tThe virus can be spread through human activity, tools, and equipment. " + "\n"
                                "2)\tFrequently wash your hands and disinfect garden tools, stakes, ties, pots, greenhouse benches, etc. (one part bleach to 4 parts water) to reduce the risk of contamination.\n" + "\n" +
                                "3)\tRemove and destroy all infected plants . Do NOT compost.\n"

                    textview2.text = remedies
                }
                else -> {
                    textview2.text = "No remedies found for the given label."
                }
            }
        }


        val imageByteArray = intent.getByteArrayExtra("image")

        // Convert the byte array back to a bitmap
        if (imageByteArray != null) {
            val originalBitmap = BitmapFactory.decodeByteArray(imageByteArray, 0, imageByteArray.size)

            // Define a scaling factor
            val scalingFactor = 4.0

            // Calculate the new width and height
            val newWidth = (originalBitmap.width * scalingFactor).toInt()
            val newHeight = (originalBitmap.height * scalingFactor).toInt()

            // Create a scaled bitmap
            val scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true)

            // Set the scaled bitmap to the ImageView
            imageView.setImageBitmap(scaledBitmap)
        }
    }
}