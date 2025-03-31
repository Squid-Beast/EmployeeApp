"use client";
import axios from "axios";
import { useEffect, useState } from "react";

interface Employee {
  firstName: string;
  lastName: string;
  joiningDate: string;
  role: string;
}

export default function Home() {
  const [employees, setEmployees] = useState<Employee[]>([]);
  const [error, setError] = useState<string | null>(null);

  useEffect(() => {
    axios
      .get<Employee[]>("http://localhost:9090/employees")
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((err) => {
        setError(err.message);
        console.error("Error fetching employees:", err);
      });
  }, []);

  if (error) {
    return <p>Error: {error}</p>;
  }

  return (
    <div>
      <h1>Employees</h1>
      {employees.length > 0 ? (
        <ul>
          {employees.map((employee, index) => (
            <li key={index}>
              {employee.firstName} {employee.lastName} - {employee.role}
            </li>
          ))}
        </ul>
      ) : (
        <p>Loading or no employees found...</p>
      )}
    </div>
  );
}
