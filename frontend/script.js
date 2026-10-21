fetch("http://localhost:8080/api/jobs")
    .then(response => response.json())
    .then(jobs => {

        const jobsContainer = document.getElementById("jobs");

        jobs.forEach(job => {

            const jobCard = document.createElement("div");

            jobCard.className = "job-card";

            jobCard.innerHTML = `
                <h3>${job.title}</h3>

                <p class="company">
                    ${job.company}
                </p>

                <p class="job-info">
                    📍 ${job.location}
                </p>

                <p class="job-info">
                    💰 ${job.salary}
                </p>

                <p class="job-info">
                    ${job.description}
                </p>

                <button 
                    class="apply-btn"
                    onclick="applyForJob(${job.id})">
                    Apply Now
                </button>
            `;

            jobsContainer.appendChild(jobCard);

        });

    })
    .catch(error => {
        console.error("Error loading jobs:", error);
    });


function applyForJob(jobId) {

    const loggedInUser = JSON.parse(
        localStorage.getItem("loggedInUser")
    );

    if (!loggedInUser) {
        alert("Please login first.");
        window.location.href = "login.html";
        return;
    }

    const application = {
        userId: loggedInUser.id,
        jobId: jobId,
        status: "APPLIED"
    }; 

    fetch("http://localhost:8080/api/applications", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(application)
    })
    .then(response => response.json())
    .then(data => {

        console.log("Application submitted:", data);

        alert("Application submitted successfully!");

    })
    .catch(error => {

        console.error("Error submitting application:", error);

        alert("Failed to submit application.");

    });
}