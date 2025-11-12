const searchBtn = document.getElementById("search-btn");
const destinationInput = document.getElementById("destination");
const weatherSection = document.getElementById("weather");
const packingSection = document.getElementById("packing");

searchBtn.addEventListener("click", async () => {
    const destination = destinationInput.value.trim();
    if (!destination) {
        alert("Please enter a destination!");
        return;
    }

    try {

        const response = await fetch("/api/weather", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ destination })
        });

        if (!response.ok) {
            throw new Error("Failed to fetch weather data");
        }

        const data = await response.json();


        const weather = data.current;
        const location = data.location;

        weatherSection.innerHTML = `
      <h2>Weather Forecast</h2>
      <p><strong>${location.name}, ${location.country}</strong></p>
      <p>${weather.weather_descriptions.join(", ")}</p>
      <p><strong>${weather.temperature}°C</strong></p>
      <p>Humidity: ${weather.humidity}%</p>
      <p>Wind: ${weather.wind_speed} km/h ${weather.wind_dir}</p>
    `;

        packingSection.innerHTML = `
      <h2>You should pack this:</h2>
      <ul>
        ${data.packingSuggestions.map(item => `<li>${item}</li>`).join("")}
      </ul>
    `;

    } catch (err) {
        console.error(err);
        alert("Something went wrong while fetching data.");
    }
});