import { useState } from "react";
import { useNavigate } from "react-router-dom";
import api from "../api/api";

const BookingForm = () => {
  const navigate = useNavigate();

  const [form, setForm] = useState({
    customerName: "",
    pickupLocation: "",
    destination: "",
  });

  const [submitting, setSubmitting] = useState(false);

  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (
      !form.customerName.trim() ||
      !form.pickupLocation.trim() ||
      !form.destination.trim()
    ) {
      alert("Please fill all fields");
      return;
    }

    setSubmitting(true);

    try {
      const response = await api.post("/bookings", form);

      navigate("/success", {
        state: response.data,
      });
    } catch (error) {
      alert(error.response?.data?.message || "Booking failed");
    } finally {
      setSubmitting(false);
    }
  };

  return (
    <div className="container">
      <h1>Book a Ride</h1>

      <form className="form-card" onSubmit={handleSubmit}>
        <input
          type="text"
          name="customerName"
          placeholder="Customer Name"
          value={form.customerName}
          onChange={handleChange}
        />

        <input
          type="text"
          name="pickupLocation"
          placeholder="Pickup Location"
          value={form.pickupLocation}
          onChange={handleChange}
        />

        <input
          type="text"
          name="destination"
          placeholder="Destination"
          value={form.destination}
          onChange={handleChange}
        />

        <div className="button-group">
          <button
            type="button"
            className="secondary-btn"
            onClick={() => navigate("/")}
          >
            ← Back
          </button>

          <button
            type="submit"
            className="primary-btn"
            disabled={submitting}
          >
            {submitting ? "Booking..." : "Book Ride"}
          </button>
        </div>
      </form>
    </div>
  );
};

export default BookingForm;