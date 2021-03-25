export function fetchGetCall(url) {
    fetch(url)
    .then(r=>{
        return r.json();
    })
    .then(r=>{
        console.log(r);
    })
}