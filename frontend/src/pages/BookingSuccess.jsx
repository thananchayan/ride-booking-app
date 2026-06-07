import { useLocation, useNavigate } from "react-router-dom";

const BookingSuccess = () => {
  const location = useLocation();
  const navigate = useNavigate();

  const booking = location.state;

  if (!booking) {
    return (
      <div className="container">
        <h2>No booking information found</h2>

        <button
          className="primary-btn"
          onClick={() => navigate("/")}
        >
          Back to Home
        </button>
      </div>
    );
  }

  return (
    <div className="container">
      <div className="success-card">
        <h1>Booking Successful</h1>

        <p>
          <strong>Driver:</strong> {booking.driverName}
        </p>

        <p>
          <strong>Vehicle:</strong> {booking.vehicleNumber}
        </p>

        <p>
          <strong>Status:</strong> {booking.status}
        </p>

        <button
          className="primary-btn"
          onClick={() => navigate("/")}
        >
          Back to Home
        </button>
      </div>
    </div>
  );
};

export default BookingSuccess;