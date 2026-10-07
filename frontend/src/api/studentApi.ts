// 1. Add the 'type' keyword to the import
import type { StudentProfile } from '../types/student';

const mockStudent: StudentProfile = {
  id: "STU-2026-001",
  firstName: "Arjun",
  lastName: "Kumar",
  grade: "10th Grade",
  feeStatus: "PENDING"
};

export const fetchStudentProfile = async (
  _id: string // 2. Prefix with an underscore to explicitly bypass the unused variable check
): Promise<StudentProfile> => {
  return new Promise((resolve) => {
    // Simulate a 1-second network latency 
    setTimeout(() => {
      resolve(mockStudent);
    }, 1000); 
  });
};