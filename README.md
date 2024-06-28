# Logistics_backend_spring_boot
load apis for liveasy logistics

Spring Boot API for Logistics Management
Overview
Simple Spring Boot API for managing logistics information
Provides endpoints to add, retrieve, update, and delete logistics details
Getting Started

>Clone the repository

>Configure Database:

Open application.properties and configure your PostgreSQL database settings.
Run the Application:

>API Endpoints

1. Insert Logistics Details
Endpoint: POST /load/save
Payload: JSON payload with logistics details
Response: "Logistics details added successfully"

2. Retrieve Logistics Details
Endpoint: GET /load
Query Parameter: shipperId (ID of the shipper)
Response: List of logistics details

3. Update Logistics Details
Endpoint: PUT /load/{loadId}
Payload: JSON payload with updated logistics details
Response: "Logistics details updated successfully"

4. Delete Logistics Details
Endpoint: DELETE /load/{loadId}
Response: "Logistics details deleted successfully"
Data Model
Uses the Logistics entity with fields like loadingPoint, unloadingPoint, etc.


Usage

Use the provided API endpoints to manage logistics details.
Customize the application based on your specific requirements.
Contributing
