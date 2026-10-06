import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App.tsx'
import { ThemeProvider, createTheme, CssBaseline } from '@mui/material'

// Create a basic enterprise theme
const theme = createTheme({
  palette: {
    primary: {
      main: '#1976d2', // Standard enterprise blue
    },
    background: {
      default: '#f4f6f8', // Light gray background for dashboards
    },
  },
});

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    <ThemeProvider theme={theme}>
      {/* CssBaseline kicks off an elegant, consistent, and simple baseline to build upon. */}
      <CssBaseline />
      <App />
    </ThemeProvider>
  </React.StrictMode>,
)