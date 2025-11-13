document.addEventListener("DOMContentLoaded", () => {
    const searchBtn = document.getElementById("search-btn");
    const destinationInput = document.getElementById("destination");
    const weatherSection = document.getElementById("weather");
    const packingSection = document.getElementById("packing");

    searchBtn.addEventListener("click", async () => {
        const location = destinationInput.value.trim();
        if (!location) {
            alert("Please enter a destination!");
            return;
        }

        weatherSection.innerHTML = "<p>Loading weather data...</p>";
        packingSection.innerHTML = "";

        try {
            const response = await fetch(`/packinglist?location=${encodeURIComponent(location)}`);
            if (!response.ok) {
                weatherSection.innerHTML = "<p>Error fetching data. Please try again.</p>";
                return;
            }

            const data = await response.json();
            // ---- SPLIT AI TEXT ----
            let aiText = "No AI packing advice available.";
            if (data.ai && data.ai.Choices && data.ai.Choices.length > 0 && data.ai.Choices[0].message && data.ai.Choices[0].message.content) {
                aiText = data.ai.Choices[0].message.content
            }

            let index = aiText.indexOf("Layers")
            let aiSummary = ""
            let aiPackage = ""

            if(index !== -1){
                aiSummary = aiText.substring(0, index).trim() //alt før "Layers"
                aiPackage = aiText.substring(index).trim() //alt efter "Layers"
            } else {
                aiSummary = aiText;
                aiPackage = "Error - no package list"
            }

            // ---- WEATHER SECTION ----
            const weather = data.weather;
            if (weather && weather.location && weather.current) {
                const location = weather.location;
                const current = weather.current;

                let iconHTML = "";
                if (current.weather_icons && current.weather_icons.length > 0) {
                    iconHTML = '<img src="' + current.weather_icons[0] + '" alt="weather icon">';
                }

                weatherSection.innerHTML =
                    '<h2>Weather in ' + location.name + ', ' + location.country + '</h2>' +
                    '<p><strong>' + current.temperature + '°C</strong>, ' + current.weather_descriptions.join(", ") + '</p>' + '<br>' +
                    iconHTML + '<br><br>' + aiSummary;
            } else {
                weatherSection.innerHTML = "<p>No weather data available.</p>";
            }
            // ---- PACKING SECTION ----
            packingSection.innerHTML = '<h2>Packing Advice</h2><p>' + aiPackage.replace(/\n/g, "<br>") + '</p>'; //erstatter alle /n med linjeskift

        } catch (error) {
            console.error(error);
            weatherSection.innerHTML = "<p>Something went wrong. Check console for details.</p>";
        }
    });

    destinationInput.addEventListener("keypress", (event) => {
        if (event.key === "Enter") {
            event.preventDefault();
            searchBtn.click();
        }
    });
});
