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

            // ---- WEATHER SECTION ----
            const weather = data.weather || {};
            if (weather.location && weather.current) {
                const { name, country } = weather.location;
                const { temperature, weather_descriptions, weather_icons } = weather.current;

                weatherSection.innerHTML = `
                    <h2>Weather in ${name}, ${country}</h2>
                    <p><strong>${temperature}°C</strong>, ${weather_descriptions.join(", ")}</p>
                    ${weather_icons?.length ? `<img src="${weather_icons[0]}" alt="weather icon">` : ""}
                `;
            } else {
                weatherSection.innerHTML = "<p>No weather data available.</p>";
            }

            // ---- PACKING SECTION ----
            const aiText = data.ai?.Choices?.[0]?.message?.content || "No AI packing advice available.";
            packingSection.innerHTML = `
                <h2>Packing Advice</h2>
                <p>${aiText.replace(/\n/g, "<br>")}</p>
            `;

        } catch (error) {
            console.error(error);
            weatherSection.innerHTML = "<p>Something went wrong. Check console for details.</p>";
        }
    });
});
