export const get = async (url) => {
  const response = await fetch(url)
  .then(r => r.json())
  .catch((error) => {
    console.log(error)
  });
  return response;
}