export interface StudentProfile {
  id: string;
  firstName: string;
  lastName: string;
  grade: string;
  feeStatus: 'PAID' | 'PENDING' | 'OVERDUE';
}