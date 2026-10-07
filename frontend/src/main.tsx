import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import { 
  ThemeProvider, 
  createTheme, 
  CssBaseline 
} from '@mui/material'
import { 
  QueryClient, 
  QueryClientProvider 
} from '@tanstack/react-query'

const queryClient = new QueryClient();

const theme = createTheme({
  palette: {
    primary: { main: '#1976d2' },
    background: { default: '#f4f6f8' },
  },
});

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <QueryClientProvider client={queryClient}>
      <ThemeProvider theme={theme}>
        <CssBaseline />
        <App />
      </ThemeProvider>
    </QueryClientProvider>
  </React.StrictMode>,
)