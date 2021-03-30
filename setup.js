const fs = require('fs');
const path = require('path');

const accept = ['ex1', 'ex2', 'ex3', 'ex4', 'ex5', 'ex6', 'ex7'];
const arg = process.argv[2];

if (!accept.includes(arg)) {
    console.error('Argument må være i listen: ' + accept.join(', '));
    process.exit(1);
}

const dir = path.join(__dirname, 'src', 'test', 'kotlin', 'no', 'utgdev', 'diy', arg);
console.log('dir', dir);

fs.readdirSync(dir)
    .forEach((file) => prepFile(path.join(dir, file)));


function prepFile(file) {
    console.log('file', file);
    const content = fs.readFileSync(file, 'utf-8');
    const prepped = content.replace(/\/\/REMOVE /g, '');
    fs.writeFileSync(file, prepped, 'utf-8');
}