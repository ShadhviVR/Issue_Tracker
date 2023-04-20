import React from "react";
import {
  createBrowserRouter,
  createRoutesFromElements,
  Route,
  RouterProvider,
} from "react-router-dom";



function AppRouter() {

  const router = createBrowserRouter(
    createRoutesFromElements(
      <>

      </>
    )
  );
  return (
    <RouterProvider router={router}></RouterProvider>
  )
}

export default function App() {
  return (
    <AppRouter />
  );

}


