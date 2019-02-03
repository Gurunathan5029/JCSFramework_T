when 'To Do', {
    'success' should: 'In Progress'
}

when 'In Progress', {
    'success' should: 'Done'
}

when 'Done', {
    'failure' should: 'To Do'
}