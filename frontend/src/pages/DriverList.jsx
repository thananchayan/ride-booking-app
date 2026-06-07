import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import api from "../api/api";

const DriverList = () => {
  const [drivers, setDrivers] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchDrivers();
  }, []);

  const fetchDrivers = async () => {
    try {
      const response = await api.get("/drivers/available");
      setDrivers(response.data);
    } catch (error) {
      console.error(error);
    } finally {
      setLoading(false);
    }
  };

  if (loading) {
    return (
      <div className="container">
        <h2>Loading drivers...</h2>
      </div>
    );
  }

  return (
    <div className="container">
      <h1>Ride Booking Application</h1>

      <h2>Available Drivers ({drivers.length})</h2>

      {drivers.length === 0 ? (
        <div className="card">
          <p>No drivers available at the moment.</p>
        </div>
      ) : (
        drivers.map((driver) => (
          <div key={driver.id} className="card">
            <h3>{driver.name}</h3>
            <p>Vehicle: {driver.vehicleNumber}</p>
          </div>
        ))
      )}

      <Link to="/book">
        <button className="primary-btn">Book Ride</button>
      </Link>
    </div>
  );
};

export default DriverList;
