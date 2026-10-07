import { useQuery } from '@tanstack/react-query';
import { 
  Card, CardContent, Typography, 
  CircularProgress, Box, Chip 
} from '@mui/material';
import { fetchStudentProfile } from '../api/studentApi';

export default function StudentDashboard() {
  const studentId = "STU-2026-001";

  const { data, isLoading, isError } = useQuery({
    queryKey: ['student', studentId],
    queryFn: () => fetchStudentProfile(studentId),
  });

  if (isLoading) {
    return (
      <Box sx={{ display: 'flex', justifyContent: 'center', mt: 4 }}>
        <CircularProgress />
      </Box>
    );
  }

  if (isError || !data) {
    return (
      <Typography color="error" align="center" sx={{ mt: 4 }}>
        Failed to load profile.
      </Typography>
    );
  }

  return (
    <Box sx={{ p: 4, maxWidth: 600, mx: 'auto' }}>
      <Typography variant="h4" gutterBottom>
        Student Dashboard
      </Typography>
      
      <Card elevation={3}>
        <CardContent>
          <Box sx={{ 
            display: 'grid', 
            gridTemplateColumns: { xs: '1fr', sm: '1fr 1fr' }, 
            gap: 2 
          }}>
            <Box>
              <Typography color="textSecondary" variant="subtitle2">
                Student ID
              </Typography>
              <Typography variant="body1">{data.id}</Typography>
            </Box>
            <Box>
              <Typography color="textSecondary" variant="subtitle2">
                Name
              </Typography>
              <Typography variant="body1">
                {data.firstName} {data.lastName}
              </Typography>
            </Box>
            <Box>
              <Typography color="textSecondary" variant="subtitle2">
                Grade
              </Typography>
              <Typography variant="body1">{data.grade}</Typography>
            </Box>
            <Box>
              <Typography color="textSecondary" variant="subtitle2">
                Fee Status
              </Typography>
              <Chip 
                label={data.feeStatus} 
                color={data.feeStatus === 'PAID' ? 'success' : 'warning'} 
                size="small"
              />
            </Box>
          </Box>
        </CardContent>
      </Card>
    </Box>
  );
}